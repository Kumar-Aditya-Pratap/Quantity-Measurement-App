import java.util.Objects;

public class QuantityMeasurementApp {

    private static final double EPSILON = 1e-6;

    public static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid numeric value");
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

        private double toBaseUnit() {
            return value * unit.getConversionFactor();
        }

        private static double fromBaseUnit(double baseValue, LengthUnit targetUnit) {
            return baseValue / targetUnit.getConversionFactor();
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double base = toBaseUnit();
            double converted = fromBaseUnit(base, targetUnit);

            return new QuantityLength(converted, targetUnit);
        }

        public static double convert(double value,
                                     LengthUnit source,
                                     LengthUnit target) {

            if (source == null || target == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid numeric value");
            }

            double base = value * source.getConversionFactor();
            return base / target.getConversionFactor();
        }

        /* ================= UC6 ADDITION ================= */

        public QuantityLength add(QuantityLength other) {

            if (other == null) {
                throw new IllegalArgumentException("Second operand cannot be null");
            }

            double sumBase = this.toBaseUnit() + other.toBaseUnit();
            double result = fromBaseUnit(sumBase, this.unit);

            return new QuantityLength(result, this.unit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof QuantityLength)) return false;

            QuantityLength other = (QuantityLength) obj;

            return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
        }

        @Override
        public int hashCode() {
            return Objects.hash(toBaseUnit());
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES));

        System.out.println(result);
    }
}