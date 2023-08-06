#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId};

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import ${groupId}.applicationservice.BookStoreService;
import ${groupId}.domainservice.DomainEventService;
import ${groupId}.domainservice.ReferenceLibrary;

public final class JexxaTemplate
{
    public static void main(String[] args)
    {
        var jexxaMain = new JexxaMain(JexxaTemplate.class);

        jexxaMain
                .bootstrap(ReferenceLibrary.class).and()       // Bootstrap latest book via ReferenceLibrary
                .bootstrap(DomainEventService.class).and()     // DomainEventService to forward DomainEvents to a message bus

                .bind(RESTfulRPCAdapter.class).to(BookStoreService.class)        // Provide REST access to BookStoreService
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext()) // Provide REST access to BoundedContext

                .run(); // Finally run the application
    }
}
