package servise;

/**
 Abstraction describing the behavior of computing objects.
 */
public interface ComplexCalculable {
    void sum(double a, double b, double c, double d);
    void multiply(double a, double b, double c, double d);
    void divide(double a, double b, double c, double d);
    void subtraction(double a, double b, double c, double d);
    double result();
    double complexResult();
    void clear();
}