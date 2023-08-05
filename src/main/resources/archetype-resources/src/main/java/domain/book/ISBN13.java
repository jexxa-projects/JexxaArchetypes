#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.book;

import io.jexxa.addend.applicationcore.ValueObject;
import io.jexxa.addend.applicationcore.ValueObjectFactory;

import java.util.Objects;

/**
 * IMPORTANT NOTE: This is a simplified ISBN13 number which only validates the checksum because this is sufficient for this tutorial
 */
@ValueObject
public record ISBN13(String isbn13)
{
    public ISBN13
    {
        // The canonical constructor must be called in all cases.
        // So we put the validation of our attributes here.
        validateChecksum(isbn13);
    }

    @ValueObjectFactory(ISBN13.class)
    public static ISBN13 createISBN(String value)
    {
        return new ISBN13(value);
    }

    private static void validateChecksum(String isbn13)
    {
        Objects.requireNonNull(isbn13);

        var digits = isbn13
                .replace("-","")
                .toCharArray();

        if (digits.length != 13)
        {
            throw new IllegalArgumentException(
                    "Invalid ISBN number: Expected number of digits is 13. Given value for ISBN number " + isbn13 + " is " + digits.length);
        }

        var digitSum = 0;

        for (var i = 0; i < digits.length - 1 ; ++i) //Exclude checksum value (which is at position digits.length -1)
        {

            var digitAsInt = Integer.parseInt(String.valueOf(digits[i]));
            if ( i % 2 == 0)
            {
                digitSum += digitAsInt;
            }
            else
            {
                digitSum += digitAsInt * 3;
            }
        }

        var calculatedCheckDigit = (10 - ( digitSum % 10 )) % 10;

        var expectedDigit =  Integer.parseInt(String.valueOf(digits[digits.length -1]));

        if ( calculatedCheckDigit != expectedDigit )
        {
            throw new IllegalArgumentException(
                    "Invalid ISBN number: Expected checksum value is "
                            + calculatedCheckDigit
                            + " Given value is "
                            + expectedDigit);
        }
    }

}
