#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.infrastructure.drivenadapter.persistence;


import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import ${groupId}.domain.book.Book;
import ${groupId}.domain.book.ISBN13;
import ${groupId}.domain.book.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static io.jexxa.infrastructure.RepositoryManager.getRepository;


@SuppressWarnings("unused")
@DrivenAdapter
public final class BookRepositoryImpl implements BookRepository
{
    private final IRepository<Book, ISBN13> repository;

    public BookRepositoryImpl(Properties properties)
    {
        this.repository = getRepository(Book.class, Book::getISBN13, properties);
    }

    @Override
    public void add(Book book)
    {
        repository.add(book);
    }

    @Override
    public Book get(ISBN13 isbn13)
    {
        return repository.get(isbn13).orElseThrow();
    }

    @Override
    public boolean isRegistered(ISBN13 isbn13)
    {
        return search(isbn13).isPresent();
    }

    @Override
    public Optional<Book> search(ISBN13 isbn13)
    {
        return repository.get(isbn13);
    }

    @Override
    public void update(Book book)
    {
        repository.update(book);
    }

    @Override
    public List<Book> getAll()
    {
        return repository.get();
    }
}
