

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // --- UC14 Temperature Tests [cite: 719, 780, 786] ---

    @Test
    void testTemperatureEquality_0CelsiusEquals32Fahrenheit() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> fahrenheit = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);
        assertEquals(celsius, fahrenheit); // [cite: 781]
    }

    @Test
    void testTemperatureConversion_CelsiusToFahrenheit() {
        Quantity<TemperatureUnit> celsius = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> converted = celsius.convertTo(TemperatureUnit.FAHRENHEIT);
        assertEquals(212.0, converted.getValue()); // [cite: 787]
    }

    @Test
    void testTemperatureUnsupportedOperation_AddThrowsException() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);
        // [cite: 596, 730]
        assertThrows(UnsupportedOperationException.class, () -> t1.add(t2));
    }

    // --- Fixed Previous UC Tests (Backward Compatibility) [cite: 666, 731] ---

    @Test
    void testLengthEquality_1FeetEquals12Inches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals(feet, inches);
    }

    @Test
    void testVolumeAddition_1LitrePlus1000MillilitresEquals2Litres() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        // Corrected: passing only the Quantity object to the add method [cite: 702]
        Quantity<VolumeUnit> result = litre.add(ml);
        assertEquals(2.0, result.getValue());
    }
}