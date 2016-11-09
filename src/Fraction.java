//Could also be written as public class Fraction extends Object

// Fractions are always stored in reduced form

public class Fraction {

    private int bottom;
    private int top;

    //Constructors for fraction class --> similar to def __init__ in Python
    public Fraction(int numer, int denom) {
        
        int Fractiongcd = gcd(numer, denom);
        top = numer / Fractiongcd;
        bottom = denom / Fractiongcd;
        /* Could also be written as:
                    this.top = numer;
                    this.bottom = denom; */
    }
    
    public Fraction(int numer) {
        this(numer, 1);
    }
    
    public int getNumer() {
        return this.top;
    }
    
    public int getDenom() {
        return this.bottom;
    }
    
    @Override
    public String toString() {
        return top + "/" + bottom;
    }
    
    public Double getDec() {
        return (double)top / (double)bottom;
    }

    public Fraction add(Fraction other) {
        int sumTop;
        int sumBottom;

        sumTop = this.top * other.bottom + other.top * this.bottom;
        sumBottom = other.bottom * this.bottom;

        Fraction answer = new Fraction(sumTop, sumBottom);

        return answer;

    }
    
    public Fraction subtract(Fraction other) {
        int difTop;
        int difBottom;
        
        difTop = other.top *this.bottom - this.top * other.bottom;
        difBottom = other.bottom * this.bottom;
        
        Fraction answer = new Fraction(difTop, difBottom);
        
        return answer;
    }
    
    public Fraction multiply(Fraction other) {
        int productTop;
        int productBottom;
        
        productTop = this.top * other.top;
        productBottom = this.bottom * other.bottom;
        
        Fraction answer = new Fraction(productTop, productBottom);
        
        return answer;
        
    }
    
    public Fraction divide(Fraction other) {
        int quotientTop;
        int quotientBottom;
        
        quotientTop = this.top * other.bottom;
        quotientBottom = this.bottom * other.top;
        
        Fraction answer = new Fraction(quotientTop, quotientBottom);
        
        return answer;
        
    }

    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        }

        return gcd(y, x % y);

    }
}
