class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction() {
        this(0, 1);
    }
    public void set(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void display() {
        System.out.println(numerator + "/" + denominator);
    }
    public boolean equals(Fraction other) {
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }
}
public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(2, 4);
        Fraction fraction2 = new Fraction(3, 6);
        System.out.println("Fraction 1:");
        fraction1.display();
        System.out.println("Fraction 2:");
        fraction2.display();
        boolean areEqual = fraction1.equals(fraction2);
        System.out.println("Are the fractions equal? " + areEqual);
    }
}