//更加的抽象化
public interface AllPredicate<T> {
    boolean test(T t);
}
