package unitTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        List<Point> pointList = Arrays.asList(new Point(1, 2), new Point(2, 4), null);
//        pointList.stream().map(point -> point.getX()).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
//        numbers.stream().map(x -> x+17).filter(x -> x%2==0).limit(3).forEach(System.out::println);

        //使用peek
        numbers.stream().peek(x ->System.out.println("From stream: "+x))
                .map(x -> x+17).peek(x -> System.out.println("after map: "+x))
                .filter(x -> x%2 == 0).peek(x -> System.out.println("after filter: "+x)).collect(Collectors.toList());
    }
}
