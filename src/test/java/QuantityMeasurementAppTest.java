import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // -------- FEET TESTS --------

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(
                QuantityMeasurementApp.checkFeetEquality(1.0, 1.0),
                "1.0 ft should be equal to 1.0 ft"
        );
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(
                QuantityMeasurementApp.checkFeetEquality(1.0, 2.0),
                "1.0 ft should not be equal to 2.0 ft"
        );
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet.equals(feet), "Feet object should be equal to itself");
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals(null), "Feet should not be equal to null");
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals("invalid"), "Feet should not equal non-Feet object");
    }

    // -------- INCHES TESTS --------

    @Test
    void testInchesEquality_SameValue() {
        assertTrue(
                QuantityMeasurementApp.checkInchesEquality(1.0, 1.0),
                "1.0 inch should be equal to 1.0 inch"
        );
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(
                QuantityMeasurementApp.checkInchesEquality(1.0, 2.0),
                "1.0 inch should not be equal to 2.0 inch"
        );
    }

    @Test
    void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(inches.equals(inches), "Inches object should be equal to itself");
    }

    @Test
    void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(inches.equals(null), "Inches should not be equal to null");
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(inches.equals("invalid"), "Inches should not equal non-Inches object");
    }
}