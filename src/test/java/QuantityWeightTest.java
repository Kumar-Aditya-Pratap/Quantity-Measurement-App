import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    @Test
    void testEquality_KilogramToKilogram() {

        QuantityWeight a = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(1, WeightUnit.KILOGRAM);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_KilogramToGram() {

        QuantityWeight a = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(1000, WeightUnit.GRAM);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_PoundToPound() {

        QuantityWeight a = new QuantityWeight(2, WeightUnit.POUND);
        QuantityWeight b = new QuantityWeight(2, WeightUnit.POUND);

        assertTrue(a.equals(b));
    }

    @Test
    void testConvert_KilogramToGram() {

        QuantityWeight weight = new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight result = weight.convertTo(WeightUnit.GRAM);

        assertEquals(1000, result.getValue(), 0.001);
    }

    @Test
    void testAddition_KilogramAndGram() {

        QuantityWeight a = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(1000, WeightUnit.GRAM);

        QuantityWeight result = a.add(b);

        assertEquals(2, result.getValue(), 0.001);
    }
}