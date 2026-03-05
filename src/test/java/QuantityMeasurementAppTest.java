import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEqualityFeetToInches() {

        QuantityMeasurementApp a =
                new QuantityMeasurementApp(1, LengthUnit.FEET);

        QuantityMeasurementApp b =
                new QuantityMeasurementApp(12, LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }

    @Test
    void testConvertFeetToInches() {

        QuantityMeasurementApp a =
                new QuantityMeasurementApp(1, LengthUnit.FEET);

        QuantityMeasurementApp result =
                a.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.001);
    }

    @Test
    void testAdditionFeetAndInches() {

        QuantityMeasurementApp a =
                new QuantityMeasurementApp(1, LengthUnit.FEET);

        QuantityMeasurementApp b =
                new QuantityMeasurementApp(12, LengthUnit.INCHES);

        QuantityMeasurementApp result =
                a.add(b, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), 0.001);
    }

    @Test
    void testAdditionDifferentUnits() {

        QuantityMeasurementApp a =
                new QuantityMeasurementApp(36, LengthUnit.INCHES);

        QuantityMeasurementApp b =
                new QuantityMeasurementApp(1, LengthUnit.YARDS);

        QuantityMeasurementApp result =
                a.add(b, LengthUnit.FEET);

        assertEquals(6.0, result.getValue(), 0.001);
    }
}