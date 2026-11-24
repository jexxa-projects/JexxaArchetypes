package ${package}.application.ports;

import io.jexxa.addend.applicationcore.InfrastructureService;

import java.util.function.Consumer;

@InfrastructureService
public interface DomainEventDispatcher {
    <T> void publish(T domainEvent);

    <T> void subscribe(Class<T> domainEvent, Consumer<T> subscriber);

    void subscribe(Consumer<Object> subscriber);
}
