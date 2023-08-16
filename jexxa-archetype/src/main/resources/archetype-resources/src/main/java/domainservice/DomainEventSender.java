#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.domainservice;


import io.jexxa.addend.applicationcore.InfrastructureService;
import ${groupId}.domain.book.BookSoldOut;

@InfrastructureService
public interface DomainEventSender
{
    void publish(BookSoldOut domainEvent);
}
