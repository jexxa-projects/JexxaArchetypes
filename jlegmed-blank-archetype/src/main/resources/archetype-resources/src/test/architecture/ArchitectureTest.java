#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.architecture;

import ${groupId}.${projectName};
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import io.jexxa.jlegmedtest.architecture.ArchitectureRules;


/**
 * This test can be used to validate the architecture of your application
 */
class ArchitectureTest {

    @Test
    void testDTOs()
    {
        //Arrange
        var dtoRules = ArchitectureRules.dtoRules(${projectName}.class);

        //Act/assert
        assertDoesNotThrow(dtoRules::validate);
    }

    @Test
    void testFilter()
    {
        //Arrange
        var filterRules = ArchitectureRules.filterRules(${projectName}.class);

        //Act/assert
        assertDoesNotThrow(filterRules::validate);
    }
}

