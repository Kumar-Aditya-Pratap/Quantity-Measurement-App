

/**
 * Functional interface to indicate whether a measurable unit supports arithmetic operations[cite: 684, 688].
 */
@FunctionalInterface
interface SupportsArithmetic {
    boolean isSupported();
}

public interface IMeasurable {
    // Default variable lambda to indicate that units support arithmetic by default [cite: 746, 756]
    SupportsArithmetic supportsArithmetic = () -> true;

    String getUnitName();
    double getConversionFactor();
    double convertToBaseUnit(double value);
    double convertFromBaseUnit(double baseValue);

    /**
     * Default method to check if arithmetic is supported[cite: 748, 758].
     */
    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    /**
     * Validates operation support at runtime. Default allows all operations[cite: 751, 758].
     */
    default void validateOperationSupport(String operation) {
        // Subclasses like TemperatureUnit can override this to throw exceptions [cite: 683, 753]
    }
}