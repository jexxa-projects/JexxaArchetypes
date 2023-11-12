#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import io.jexxa.jlegmed.core.JLegMed;
import java.util.concurrent.TimeUnit;
import static org.slf4j.LoggerFactory.getLogger;

public final class ${projectName}
{
    public static void main(String[] args)
    {
        var jLegMed = new JLegMed(${projectName}.class);

        jLegMed.newFlowGraph("HelloWorld")
                .every(1, TimeUnit.SECONDS)

                .receive(String.class).from( () -> "Hello " )
                .and().processWith(data -> data + "World" )
                .and().consumeWith(data -> getLogger(${projectName}.class).info(data));

        jLegMed.run();
    }
}
