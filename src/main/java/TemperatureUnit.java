

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {
    CELSIUS(false),
    FAHRENHEIT(true),
    KELVIN(false); // UC14 includes Kelvin [cite: 510, 726]

    private final boolean isFahrenheit;

    // Functional Interfaces for non-linear temperature conversion [cite: 696, 766]
    final Function<Double, Double> FAHRENHEIT_TO_CELSIUS = (fahrenheit) -> (fahrenheit - 32) * 5 / 9.0;
    final Function<Double, Double> CELSIUS_TO_CELSIUS = (celsius) -> celsius;
    final Function<Double, Double> KELVIN_TO_CELSIUS = (kelvin) -> kelvin - 273.15;

    TemperatureUnit(boolean isFahrenheit) {
        this.isFahrenheit = isFahrenheit;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public double getConversionFactor() {
        return 1.0; // Temperature uses formulas, not simple factors [cite: 767]
    }

    @Override
    public double convertToBaseUnit(double value) {
        if (this == FAHRENHEIT) return FAHRENHEIT_TO_CELSIUS.apply(value);
        if (this == KELVIN) return KELVIN_TO_CELSIUS.apply(value);
        return CELSIUS_TO_CELSIUS.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        if (this == FAHRENHEIT) return (baseValue * 9 / 5.0) + 32;
        if (this == KELVIN) return baseValue + 273.15;
        return baseValue;
    }

    @Override
    public boolean supportsArithmetic() {
        return false; // Temperature does not support arithmetic [cite: 698, 768]
    }

    @Override
    public void validateOperationSupport(String operation) {
        if (!supportsArithmetic()) {
            throw new UnsupportedOperationException(this.name() + " does not support " + operation + " operations.");
        }
    }
}