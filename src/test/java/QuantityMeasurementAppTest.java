import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // -------- LENGTH TESTS --------
    @Test
    void testLengthEquality() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    // -------- WEIGHT TESTS --------
    @Test
    void testWeightEquality() {
        Quantity<WeightUnit> q1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    // -------- VOLUME TESTS (UC11) --------

    @Test
    void testVolumeEquality_LitreToMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    void testVolumeConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    @Test
    void testVolumeConversion_GallonToLitre() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = v1.convertTo(VolumeUnit.LITRE);

        assertEquals(3.78541, result.getValue(), 0.01);
    }

    @Test
    void testVolumeAddition() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = v1.add(v2);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    @Test
    void testVolumeAddition_WithTargetUnit() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = v1.add(v2, VolumeUnit.MILLILITRE);

        assertEquals(4785.41, result.getValue(), 0.1);
    }

    @Test
    void testCrossCategoryComparison() {
        Quantity<VolumeUnit> v = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> l = new Quantity<>(1.0, LengthUnit.FEET);

        assertFalse(v.equals(l));
    }
}