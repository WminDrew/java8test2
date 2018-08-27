import sun.security.krb5.internal.APOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestLambda {

    public static List<Apple> map(List<Double> list,Function<Double,Apple> f){
        List<Apple> array = new ArrayList<Apple>();
        for(Double a:list){
            array.add(f.apply(a));
        }
        return array;
    }
    public static void main(String[] args) {
        //局部变量必须是final，或者是隐式的final
//        int value = 1000;
//        Runnable r = () -> System.out.println(value);
//        r.run();

//        List<String> strList = Arrays.asList("asd", "jav", "cjj", "csd", "dva");
//        strList.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
//        System.out.println(strList);

        //方法引用
//        strList.sort(String::compareToIgnoreCase);

//        Function<String,Integer> f = s -> Integer.parseInt(s);
//        Function<String,Integer> f = Integer::parseInt;
//        Integer value = f.apply("123344");
//        System.out.println(value);

//        Supplier supplier = () -> new Apple();
//        Object ss = supplier.get();
//        //等价于
//        Supplier supplier1 = Apple::new;
//
//        Function<Double,Apple> f = (Double i) -> new Apple(i);
//        Function<Double,Apple> function = Apple::new;
//        Apple a = function.apply(10.0);

//        BiFunction<Double,String,Apple> function = Apple::new;
//        Apple apple = function.apply(10.0,"red");
//        System.out.println(apple);

    }
}
