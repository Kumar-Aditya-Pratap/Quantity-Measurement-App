

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    @Test
    void testAddition_1FeetPlus2Inches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(2.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = feet.add(inches);
        // Fixed: Use result.getValue() to compare with double [cite: 709, 787]
        assertEquals(14.0, result.convertTo(LengthUnit.INCHES).getValue());
    }

    @Test
    void testDivision_2FeetDividedBy2() {
        Quantity<LengthUnit> feet = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = feet.divide(2.0);
        assertEquals(1.0, result.getValue());
    }
}