public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double toFeet;

    LengthUnit(double toFeet) {
        this.toFeet = toFeet;
    }

    public double toBaseUnit(double value) {
        return value * toFeet;
    }

    public double fromBaseUnit(double feetValue) {
        return feetValue / toFeet;
    }
}