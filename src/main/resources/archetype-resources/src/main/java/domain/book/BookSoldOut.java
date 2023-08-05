#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.book;

import io.jexxa.addend.applicationcore.DomainEvent;

import java.util.UUID;

@DomainEvent
public record BookSoldOut(UUID uuid, ISBN13 isbn13)
{
    public static BookSoldOut bookSoldOut(UUID uuid, ISBN13 isbn13)
    {
        return new BookSoldOut(uuid, isbn13);
    }
}
