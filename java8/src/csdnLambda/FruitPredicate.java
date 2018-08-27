package csdnLambda;

@FunctionalInterface
public interface FruitPredicate<T,R> {
    R test(T t);
}
