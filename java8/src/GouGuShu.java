import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GouGuShu {
    public static void main(String[] args) {
        //求勾股数1
//        Stream<int[]> gouGuShus = IntStream.rangeClosed(1, 100).boxed().flatMap(
//                a -> IntStream.rangeClosed(a, 100)
//                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
//        );
//
//        gouGuShus.forEach(x -> System.out.println(Arrays.toString(x)));

        //求勾股数2
        Stream<double[]> gouGuShus = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[]{a, b, Math.sqrt(a ^ 2 + b ^ 2)})
                .filter(t -> t[2] % 1 == 0)
        );
        gouGuShus.limit(5).forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
