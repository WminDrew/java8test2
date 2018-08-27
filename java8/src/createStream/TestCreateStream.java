package createStream;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestCreateStream {
    public static void main(String[] args) {

        //1.由值创建流
//        Stream<String> stream = Stream.of("java8", "Lambda", "in", "Action");
//        stream.map(s -> s.toUpperCase()).forEach(System.out::println);

        //2.由数组创建流
//        int[] ints = new int[]{12, 3, 45, 6, 32};
//        int sum = Arrays.stream(ints).sum();
//        System.out.println(sum);
//
//        String[] strs = new String[]{"java", "c++", "c#", "python"};
//        Arrays.stream(strs).filter(s ->s.length()>3).map(s -> s.toUpperCase()).forEach(System.out::println);

        //3.由io流生成的流 -->lambdaFile包中

        //4.iterate生成无限流（有次序）
//        Stream.iterate(0,i ->i+2).limit(10).forEach(System.out::println);
        //生成斐波那契数列
//        Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[0]+t[1]}).limit(20).map(t->t[0]).forEach(System.out::println);

        //5.generate
        Stream.generate(Math::random).limit(5).map(x -> (int)(x*10)).forEach(System.out::println);

    }
}
