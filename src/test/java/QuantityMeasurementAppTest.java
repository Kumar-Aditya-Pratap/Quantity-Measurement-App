import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);
        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_DifferentValues() {
        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(2.0, LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_SameReference() {
        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
    }
}