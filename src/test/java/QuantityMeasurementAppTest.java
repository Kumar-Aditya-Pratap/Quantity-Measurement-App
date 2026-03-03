import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testAddition_SameUnit() {

        var result =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityMeasurementApp.QuantityLength(2.0, LengthUnit.FEET));

        assertEquals(
                new QuantityMeasurementApp.QuantityLength(3.0, LengthUnit.FEET),
                result
        );
    }

    @Test
    void testAddition_CrossUnit() {

        var result =
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCHES));

        assertEquals(
                new QuantityMeasurementApp.QuantityLength(2.0, LengthUnit.FEET),
                result
        );
    }

    @Test
    void testAddition_Null() {

        assertThrows(IllegalArgumentException.class,
                () -> new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET)
                        .add(null));
    }
}