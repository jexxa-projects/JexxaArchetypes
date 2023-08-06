#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.applicationservice;

import io.jexxa.addend.applicationcore.DomainService;
import ${groupId}.${project-name};
import ${groupId}.domain.book.BookNotInStockException;
import ${groupId}.domain.book.BookRepository;
import ${groupId}.domain.book.BookSoldOut;
import ${groupId}.domain.book.ISBN13;
import ${groupId}.domainservice.DomainEventSender;
import io.jexxa.jexxatest.JexxaTest;
import io.jexxa.jexxatest.infrastructure.messaging.recording.MessageRecorder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ${groupId}.domain.book.ISBN13.createISBN;
import static io.jexxa.jexxatest.JexxaTest.getJexxaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *  This test validates the BookStoreService.
 *  <br>
 *  The main purpose of this test is to show the usage of JexxaTest. JexxaTest replaces all infrastructure
 *  components such as a database or message bus by stubs. There is no need to use any mocks!
 *  <br>
 *  General note: Within DDD you should focus on testing aggregates since they contain your business logic. So this test
 *  is mainly for demonstrating purpose that may be helpful to show the potential of an onion architecture and to
 *  support the transition from mock tests to pure unit tests.
 */
class BookStoreServiceTest
{
    private static final ISBN13 ANY_BOOK = createISBN("978-3-86490-387-8" );

    private BookStoreService objectUnderTest;       // Object we want to test
    private MessageRecorder publishedDomainEvents; // Message recorder to validate published DomainEvents
    private BookRepository bookRepository;          // Repository to validate results in the tests


    @BeforeEach
    void initTest()
    {
        // JexxaTest is created for each test. It provides stubs for running your tests so that no
        // mock framework is required. It expects the class name your application!
        JexxaTest jexxaTest = getJexxaTest(${project-name}.class);

        // Request the objects needed for our tests
        objectUnderTest       = jexxaTest.getInstanceOfPort(BookStoreService.class);   // 1. We need the object we want to test
        publishedDomainEvents = jexxaTest.getMessageRecorder(DomainEventSender.class); // 2. A recorder for DomainEvents published via DomainEventSender
        bookRepository        = jexxaTest.getRepository(BookRepository.class);         // 3. Repository managing all books

        // Invoke all bootstrapping services from main to ensure same starting point
        jexxaTest.getJexxaMain().bootstrapAnnotation(DomainService.class);
    }

    @Test
    void addBooksToStock()
    {
        //Arrange
        var amount = 5;

        //Act
        objectUnderTest.addToStock(ANY_BOOK, amount);

        //Assert
        assertEquals( amount, objectUnderTest.amountInStock(ANY_BOOK) );      // Perform assertion against the object we test
        assertEquals( amount, bookRepository.get(ANY_BOOK).amountInStock() ); // Perform assertion against the repository
        assertTrue( publishedDomainEvents.isEmpty() );                        // Perform assertion against published DomainEvents
    }


    @Test
    void sellBook() throws BookNotInStockException
    {
        //Arrange
        var amount = 5;
        objectUnderTest.addToStock(ANY_BOOK, amount);

        //Act
        objectUnderTest.sell(ANY_BOOK);

        //Assert
        assertEquals( amount - 1, objectUnderTest.amountInStock(ANY_BOOK) );       // Perform assertion against the object we test
        assertEquals( amount - 1, bookRepository.get(ANY_BOOK).amountInStock() );  // Perform assertion against the repository
        assertTrue( publishedDomainEvents.isEmpty() );                                     // Perform assertion against published DomainEvents
    }

    @Test
    void sellBookNotInStock()
    {
        //Arrange - Nothing

        //Act/Assert
        assertThrows(BookNotInStockException.class, () -> objectUnderTest.sell(ANY_BOOK));
    }

    @Test
    void sellLastBook() throws BookNotInStockException
    {
        //Arrange
        objectUnderTest.addToStock(ANY_BOOK, 1);

        //Act
        objectUnderTest.sell(ANY_BOOK);

        //Assert
        assertEquals( 0 , objectUnderTest.amountInStock(ANY_BOOK) );                    // Perform assertion against the object we test
        assertEquals( 1 , publishedDomainEvents.size() );                               // Perform assertion against the repository
        assertEquals( ANY_BOOK, publishedDomainEvents.getMessage(BookSoldOut.class).isbn13());  // Perform assertion against published DomainEvents
    }

}