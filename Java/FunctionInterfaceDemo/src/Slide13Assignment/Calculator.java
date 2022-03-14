package Slide13Assignment;

@FunctionalInterface
public interface Calculator<T> {
    <T> compute(<T> a, <T> b);
}
