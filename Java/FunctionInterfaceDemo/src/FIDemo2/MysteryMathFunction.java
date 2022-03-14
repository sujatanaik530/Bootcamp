package FIDemo2;

@FunctionalInterface
public interface MysteryMathFunction {
    public int VALUE = 4; // final static implied
    public int f(int n); // abstract implied
}