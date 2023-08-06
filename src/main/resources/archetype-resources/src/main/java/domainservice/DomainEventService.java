#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.domainservice;


import io.jexxa.addend.applicationcore.DomainEventHandler;
import io.jexxa.addend.applicationcore.DomainService;
import ${groupId}.domain.DomainEventPublisher;
import ${groupId}.domain.book.BookSoldOut;

@SuppressWarnings("unused")
@DomainService
public class DomainEventService
{
    private final DomainEventSender domainEventSender;
    @SuppressWarnings("unused")
    public DomainEventService(DomainEventSender domainEventSender)
    {
        this.domainEventSender = domainEventSender;
        DomainEventPublisher.subscribe(BookSoldOut.class, this::handleEvent);
    }

    @DomainEventHandler
    public void handleEvent(BookSoldOut domainEvent)
    {
        domainEventSender.publish(domainEvent);
    }
}
