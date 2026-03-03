import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToYard_SameValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        var q2 = new QuantityMeasurementApp.QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToInch_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        var q2 = new QuantityMeasurementApp.QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_CentimeterToCentimeter_SameValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(2.0, LengthUnit.CENTIMETERS);
        var q2 = new QuantityMeasurementApp.QuantityLength(2.0, LengthUnit.CENTIMETERS);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_CentimeterToInch_EquivalentValue() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.CENTIMETERS);
        var q2 = new QuantityMeasurementApp.QuantityLength(0.393701, LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_CentimeterToFeet_NotEqual() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.CENTIMETERS);
        var q2 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        var yard = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        var feet = new QuantityMeasurementApp.QuantityLength(3.0, LengthUnit.FEET);
        var inch = new QuantityMeasurementApp.QuantityLength(36.0, LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_DifferentValues() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var q2 = new QuantityMeasurementApp.QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_SameReference() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q1));
    }

    @Test
    void testEquality_NullComparison() {
        var q1 = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARDS);
        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.QuantityLength(1.0, null);
        });
    }
}