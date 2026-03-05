public final class Length {

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
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

    // UC6 behaviour (implicit result unit)
    public Length add(Length other) {
        return add(other, this.unit);
    }

    // UC7 behaviour (explicit target unit)
    public Length add(Length other, LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Other length cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double thisInFeet = this.unit.toBaseUnit(this.value);
        double otherInFeet = other.unit.toBaseUnit(other.value);

        double sumFeet = thisInFeet + otherInFeet;

        double resultValue = targetUnit.fromBaseUnit(sumFeet);

        return new Length(resultValue, targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}