#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.infrastructure.drivenadapter.messaging;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.common.drivenadapter.messaging.MessageSenderManager;
import io.jexxa.common.drivenadapter.messaging.MessageSender;
import ${groupId}.domain.book.BookSoldOut;
import ${groupId}.domainservice.DomainEventSender;

import java.util.Objects;
import java.util.Properties;

import static io.jexxa.common.drivenadapter.messaging.MessageSenderManager.getMessageSender;

@SuppressWarnings("unused")
@DrivenAdapter
public class DomainEventSenderImpl implements DomainEventSender
{
    private final MessageSender messageSender;

    public DomainEventSenderImpl(Properties properties)
    {
        messageSender = getMessageSender(DomainEventSender.class, properties);
    }

    @Override
    public void publish(BookSoldOut domainEvent)
    {
        Objects.requireNonNull(domainEvent);
        messageSender
                .send(domainEvent)
                .toTopic("BookStoreTopic")
                .addHeader("Type", domainEvent.getClass().getSimpleName())
                .asJson();
    }
}
