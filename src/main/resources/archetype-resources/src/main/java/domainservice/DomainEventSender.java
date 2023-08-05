#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domainservice;


import io.jexxa.addend.applicationcore.InfrastructureService;
import ${package}.domain.book.BookSoldOut;

@InfrastructureService
public interface DomainEventSender
{
    void publish(BookSoldOut domainEvent);
}
