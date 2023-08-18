#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.architecture;

import ${package}.JexxaBlankArchetype;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.jexxa.jexxatest.architecture.ArchitectureRules.aggregateRules;
import static io.jexxa.jexxatest.architecture.ArchitectureRules.patternLanguage;
import static io.jexxa.jexxatest.architecture.ArchitectureRules.portsAndAdapters;

/**
 * This test can be used to validate the architecture of your application
 * <p>
 * You have only to adjust test validatePortsAndAdapters. Here you have to add all your
 * packages containing the driven and driving adapters. This information is required to ensure
 * that there are no dependencies between these packages.
 */
class ArchitectureTest {

    @Test
    void validatePortsAndAdapters()
    {
        portsAndAdapters(JexxaBlankArchetype.class)
                // Add all packages providing driven adapter
                .addDrivenAdapterPackage("persistence")
                .addDrivenAdapterPackage("messaging")

                // Add all packages providing driving adapter such as
                .addDrivingAdapterPackage("messaging")

                .validate();
    }

    @Test
    void validatePatternLanguage()
    {
        patternLanguage(JexxaBlankArchetype.class).validate();
    }

    @Test
    @Disabled("Enable test after adding your first aggregate")
    void validateAggregateRules()
    {
        aggregateRules(JexxaBlankArchetype.class).validate();
    }
}