#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.domain.book;


import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository
{
    void add(Book book);

    Book get(ISBN13 isbn13);

    boolean isRegistered(ISBN13 isbn13);

    Optional<Book> search(ISBN13 isbn13);

    void update(Book book);

    List<Book> getAll();
}
