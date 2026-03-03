public enum LengthUnit {

    FEET(1.0),                // Base unit
    INCHES(1.0 / 12.0),       // 1 inch = 1/12 feet
    YARDS(3.0),               // 1 yard = 3 feet
    CENTIMETERS(0.0328084);   // 1 cm = 0.0328084 feet

    private final double conversionFactorToFeet;

    LengthUnit(double conversionFactorToFeet) {
        this.conversionFactorToFeet = conversionFactorToFeet;
    }

    public double getConversionFactor() {
        return conversionFactorToFeet;
    }
}