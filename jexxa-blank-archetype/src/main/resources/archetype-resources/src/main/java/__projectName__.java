#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.jexxa.adapters.rest.RESTfulRPCAdapter;
import io.jexxa.core.JexxaMain;

public final class ${projectName}
{
    public static void main()
    {
        var jexxaMain = new JexxaMain(${projectName}.class);

        jexxaMain
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext()) // Provide REST access to BoundedContext

                .run(); // Finally run the application
    }
}
