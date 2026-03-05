public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println(l1.add(l2, LengthUnit.FEET));
        System.out.println(l1.add(l2, LengthUnit.INCHES));
        System.out.println(l1.add(l2, LengthUnit.YARDS));

        Length l3 = new Length(1.0, LengthUnit.YARDS);
        Length l4 = new Length(3.0, LengthUnit.FEET);

        System.out.println(l3.add(l4, LengthUnit.YARDS));
    }
}