public class QuantityMeasurementApp {

    private final double value;
    private final LengthUnit unit;

    public QuantityMeasurementApp(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Convert to another unit
     */
    public QuantityMeasurementApp convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);

        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityMeasurementApp(converted, targetUnit);
    }

    /**
     * Equality check using base unit
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof QuantityMeasurementApp)) return false;

        QuantityMeasurementApp other = (QuantityMeasurementApp) obj;

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double epsilon = 0.0001;

        return Math.abs(thisBase - otherBase) < epsilon;
    }

    /**
     * Add two quantities with explicit target unit
     */
    public QuantityMeasurementApp add(QuantityMeasurementApp other, LengthUnit targetUnit) {

        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityMeasurementApp(result, targetUnit);
    }

    /**
     * Add two quantities (result in first operand unit)
     */
    public QuantityMeasurementApp add(QuantityMeasurementApp other) {
        return add(other, this.unit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}