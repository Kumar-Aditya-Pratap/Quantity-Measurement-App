

import java.util.Objects;

public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return Math.round(value * 100.0) / 100.0; // Rounding for precision [cite: 586, 709]
    }

    public Quantity<U> convertTo(U targetUnit) {
        double baseValue = this.unit.convertToBaseUnit(this.value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> that) {
        this.unit.validateOperationSupport("addition"); // Validation [cite: 702, 774]
        double sum = this.unit.convertToBaseUnit(this.value) + that.unit.convertToBaseUnit(that.value);
        return new Quantity<>(this.unit.convertFromBaseUnit(sum), this.unit);
    }

    public Quantity<U> subtract(Quantity<U> that) {
        this.unit.validateOperationSupport("subtraction");
        double diff = this.unit.convertToBaseUnit(this.value) - that.unit.convertToBaseUnit(that.value);
        return new Quantity<>(this.unit.convertFromBaseUnit(diff), this.unit);
    }

    public Quantity<U> divide(double divisor) {
        this.unit.validateOperationSupport("division");
        return new Quantity<>(this.value / divisor, this.unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity<?> that = (Quantity<?>) o;

        // Prevent cross-category comparison [cite: 665, 712, 732]
        if (!this.unit.getClass().equals(that.unit.getClass())) return false;

        double v1 = this.unit.convertToBaseUnit(this.value);
        double v2 = ((IMeasurable) that.unit).convertToBaseUnit((double) that.value);
        return Math.abs(v1 - v2) < 0.01; // Epsilon for precision [cite: 567, 778]
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}