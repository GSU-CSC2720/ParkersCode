 package lab2;

public class Rational {

    private int a;      //numerator
    private int b;      //denominator
    
    //Constructors
    public Rational() {
        a = 1; b = 1;
    }
    
    public Rational(int n, int d) {
        if (d == 0) throw new ZeroDenominatorException("Denominator must be non-zero!");
        a = n; b = d;
        normalize();
    }
    
    //public methods
    public int getNumerator()   { return a; }
    public int getDenominator() { return b; }
    public Rational negate()    { return new Rational(-1*a,b); }
    public Rational invert()    { return new Rational(b,a); }
    public String toString()    { return String.format("%s / %s\n", a, b); }
    
    
    public Rational add(Rational other) {  
        int c = other.getNumerator(), d = other.getDenominator();
        return new Rational(a*d + c*b, b*d);
    }
    
    public Rational subtract(Rational other) {               
        return add(other.negate());
    }
    
    public Rational multiply(Rational other) {       
        int c = other.getNumerator(), d = other.getDenominator();
        return new Rational(a*c, b*d);
    }
       
    public Rational divide(Rational other) {               
        return multiply(other.invert());
    }
    
    //private methods
    private void normalize() {
        int div = gcd(Math.abs(a), Math.abs(b));
        a = (a / div) * (b > 0 ? 1 : -1);
        b = Math.abs(b / div);
    }
 
    private int gcd(int a, int b) {
       return a == 0 ? b : gcd(b % a, a); 
    }   
    
}
