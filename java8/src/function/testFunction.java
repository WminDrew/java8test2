package function;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

public class testFunction {
    public static<T> void forEach(List<T> list, Consumer<T> c){
        for (T i : list){
            c.accept(i);
        }
    }

    public static<T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T i : list){
            result.add(f.apply(i));
        }
        return result;
    }

    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,5,6,7),x -> System.out.println(x));
        List<Integer> result = map(Arrays.asList("lambda", "java8", "action"), s -> s.length());
        forEach(result,x-> System.out.println(x));

    }
}
