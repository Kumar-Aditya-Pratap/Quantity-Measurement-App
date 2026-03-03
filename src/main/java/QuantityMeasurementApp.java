import java.util.Objects;

/**
 * QuantityMeasurementApp provides conversion and equality
 * operations for different length units.
 */
public class QuantityMeasurementApp {

    private static final double EPSILON = 1e-6;

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {

            validateValue(value);

            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            this.value = value;
            this.unit = unit;
        }

        private static void validateValue(double value) {
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }
        }

        private double toBaseUnit() {
            return unit.toFeet(value);
        }

        /**
         * Converts this quantity to target unit and returns new QuantityLength
         */
        public QuantityLength convertTo(LengthUnit targetUnit) {

            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double baseValue = toBaseUnit();
            double convertedValue = targetUnit.fromFeet(baseValue);

            return new QuantityLength(convertedValue, targetUnit);
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
        }

        @Override
        public int hashCode() {
            return Objects.hash(toBaseUnit());
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    /**
     * Static conversion API
     */
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double base = source.toFeet(value);
        return target.fromFeet(base);
    }

    /**
     * Overloaded conversion method (raw values)
     */
    public static void demonstrateLengthConversion(double value,
                                                   LengthUnit from,
                                                   LengthUnit to) {

        double result = convert(value, from, to);
        System.out.println("Converted: " + value + " " + from + " = " + result + " " + to);
    }

    /**
     * Overloaded conversion method (existing object)
     */
    public static void demonstrateLengthConversion(QuantityLength quantity,
                                                   LengthUnit to) {

        QuantityLength converted = quantity.convertTo(to);
        System.out.println("Converted: " + quantity + " = " + converted);
    }

    /**
     * Demonstrates equality check
     */
    public static void demonstrateLengthEquality(QuantityLength q1,
                                                 QuantityLength q2) {

        System.out.println(q1 + " equals " + q2 + " ? " + q1.equals(q2));
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);

        QuantityLength q = new QuantityLength(1.0, LengthUnit.YARDS);
        demonstrateLengthConversion(q, LengthUnit.INCH);

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        demonstrateLengthEquality(q1, q2);
    }
}