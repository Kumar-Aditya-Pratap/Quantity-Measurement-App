import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.value = value;
        this.unit = unit;
    }

    // ✅ Getter for value (fix for your error)
    public double getValue() {
        return value;
    }

    // ✅ Optional getter
    public U getUnit() {
        return unit;
    }

    // ✅ Equality check
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Quantity<?>)) return false;

        Quantity<?> that = (Quantity<?>) obj;

        // Prevent cross-category comparison
        if (this.unit.getClass() != that.unit.getClass()) return false;

        double thisBase = this.unit.convertToBaseUnit(this.value);
        double thatBase = that.unit.convertToBaseUnit(that.value);

        return Double.compare(thisBase, thatBase) == 0;
    }

    // ✅ Conversion
    public Quantity<U> convertTo(U targetUnit) {
        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        // round to 2 decimal places
        convertedValue = Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(convertedValue, targetUnit);
    }

    // ✅ Addition (default unit = this.unit)
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    // ✅ Addition with target unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double thisBase = this.unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;
        double result = targetUnit.convertFromBaseUnit(sumBase);

        // round to 2 decimal places
        result = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(result, targetUnit);
    }

    // ✅ hashCode
    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        return Objects.hash(baseValue, unit.getClass());
    }

    // ✅ toString
    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}