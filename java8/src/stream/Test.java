package stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french fries",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
        );

//        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300)
//                .map(Dish::getName)
//                .limit(3)
//                .collect(toList());
//        System.out.println(threeHighCaloricDishNames);

//        List<String> title = Arrays.asList("java", "python", "c#", "c++");
//        Stream<String> s = title.stream();
//        s.forEach(System.out::println);
//        s.forEach(System.out::println);//抛出异常

        //筛选出不重复的偶数
//        List<Integer> intList = Arrays.asList(1,3,2,4,3,7,5,6,6);
//        intList.stream().filter(x -> x%2 == 0).distinct().forEach(System.out::println);
//        menu.stream().filter( m -> m.getCalories() > 300).sorted((m1,m2) ->m2.getCalories()-m1.getCalories()).skip(3).forEach(System.out::println);

//        List<Integer> list = menu.stream().map(m -> m.getName()).map(n -> n.length()).collect(toList());
//        System.out.println(list);

//        List<String> words = Arrays.asList("Hello","World");
//        List<String[]> list = words.stream().map(s -> s.split("")).distinct().collect(toList());
//        System.out.println(list);
//        List<String> list1 = words.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(toList());
//        System.out.println(list1);

        /**
         * 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
         该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代
         表数对。
         */
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<Integer> numbers2 = Arrays.asList(3, 4);
//        List<int[]> result = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());
//        List<int[]> result2 = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(toList());
//        result.forEach(x-> System.out.println(Arrays.toString(x)));
//        result2.forEach(x -> System.out.println(Arrays.toString(x)));
//        for (int[] ints : result){
//            System.out.println(Arrays.toString(ints));
//        }

//        boolean result = menu.stream().anyMatch(Dish::isVegetarian);//至少匹配一个元素
//        System.out.println(result);
//        result = menu.stream().allMatch(x -> x.getCalories()>300);//匹配所有元素
//        System.out.println(result);
//        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
//        List<Integer> numbers2 = Arrays.asList(4, 5);
//        List<int[]> result1 = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());
//        result1.forEach(x -> System.out.println(Arrays.toString(x)));
//        List<int[]> result2 = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(toList());
//        result2.forEach(x -> System.out.println(Arrays.toString(x)));

        //找到一份素菜
//        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
//        dish.ifPresent(x -> System.out.println(x.getName()));

        List<Integer> someNumers = Arrays.asList(1, 2, 3, 4, 5);
//        Optional<Integer> firstSquareDivisibleByThree = someNumers.stream().map(x -> x * x).filter(y -> y % 3 == 0).findFirst();
//        firstSquareDivisibleByThree.ifPresent(x -> System.out.println(x));
//        Integer result = someNumers.stream().reduce(0, (a, b) -> a + b);
//        Integer result2 = someNumers.stream().reduce(1, (a, b) -> a * b);
//        System.out.println(result);
//        System.out.println(result2);
//
//        Optional<Integer> result3 = someNumers.stream().reduce((a, b) -> a + b);
//        Optional<Integer> result4 = someNumers.stream().reduce((a, b) -> a * b);
//        result3.ifPresent(x -> System.out.println(x));
//        result4.ifPresent(x -> System.out.println(x));

        //使用reduce计算最大值
//        someNumers.stream().reduce((x,y) ->x > y ? x : y).ifPresent(x -> System.out.println(x));
//        Integer result = someNumers.stream().reduce(0, (x, y) -> x > y tr? x : y);
//        System.out.println(result);
//        someNumers.stream().reduce(Integer::max).ifPresent(System.out::println);

        //使用特化流IntStream()求菜单卡路里的和，最大值，最小值，平均值
//        int sum = menu.stream().mapToInt(m -> m.getCalories()).sum();
//        OptionalInt max = menu.stream().mapToInt(m -> m.getCalories()).max();
//        OptionalInt min = menu.stream().mapToInt(m -> m.getCalories()).min();
//        OptionalDouble average = menu.stream().mapToInt(m -> m.getCalories()).average();
//        System.out.println("sum:"+sum);
//        max.ifPresent(System.out::println);
//        min.ifPresent(System.out::println);
//        average.ifPresent(System.out::println);
//
//        //如果没有最大值返回0，没有最小值返回-1
//        int mx = max.orElse(0);
//        int mn = min.orElse(-1);
//        System.out.println("max:"+mx+",min:"+mn);

//        IntStream.rangeClosed(1,100).filter(i -> i%2 == 0).forEach(System.out::println);

        //***************************--收集器--*********************************
        //计算一下有多少种菜
//        Long howManyDish = menu.stream().collect(counting());
//        System.out.println(howManyDish);
//        howManyDish= menu.stream().count();//简便写法
//
//        //寻找最高热量的菜
//        Comparator<Dish> c = Comparator.comparingInt(Dish::getCalories);
//        Optional<Dish> maxCaloriesDish = menu.stream().collect(maxBy(c));//maxBy(c)-->收集器
//        maxCaloriesDish.ifPresent(System.out::println);
//        Optional<Dish> minCaloriesDish = menu.stream().collect(minBy(c));
//        minCaloriesDish.ifPresent(System.out::println);
//
//        //把菜单的卡路里求和
//        Integer sumCalories = menu.stream().collect(summingInt(Dish::getCalories));
//        System.out.println("sumCalories:"+sumCalories);
//        //求菜单卡路里的平均值
//        Double averageCalories = menu.stream().collect(averagingDouble(Dish::getCalories));
//        System.out.println("averageCalories:"+averageCalories);
//
//        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
//        System.out.println(menuStatistics);
//        System.out.println("sumCalories: "+menuStatistics.getSum()+",maxCalories: "+menuStatistics.getMax()+",minCalories: "+menuStatistics.getMin()+
//        ",averageCalories: "+menuStatistics.getAverage()+",count: "+menuStatistics.getCount()
//        );
//
//        //字符串连接
//        String allDishname = menu.stream().map(m -> m.getName()).collect(joining(", "));
//        System.out.println("allDishname:"+allDishname);
//
//        Integer result = menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> a + b));//上面的Integer sumCalories = menu.stream().collect(summingInt(Dish::getCalories));规约的特化
//        Long count = menu.stream().collect(reducing(0L, m -> 1L, Long::sum));
//        System.out.println(result);
//        System.out.println(count);

        //分组，按菜的类型分组
        Map<Dish.Type, List<Dish>> dishGroupByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishGroupByType);

        //把菜分为高热量和低热量和正常热量的
        Map<Dish.CaloricLevel, List<Dish>> dishGroupByCalorie = menu.stream().collect(groupingBy(d -> {
            if (d.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (d.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        }));
        System.out.println(dishGroupByCalorie);

        //多级分组
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishGroupByTypeAndCalorie = menu.stream().collect(groupingBy(Dish::getType, groupingBy(d -> {
            if (d.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (d.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        })));

        System.out.println(dishGroupByTypeAndCalorie);

        Map<Dish.Type, Long> dishGroupBycount = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(dishGroupBycount);

        //把各个菜类的最高热量找出来
        Map<Dish.Type, Optional<Dish>> everyTypeDishMaxCalories = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println("everyTypeDishMaxCalories:"+everyTypeDishMaxCalories);

        Map<Dish.Type, Dish> mostCaloriesByType = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloriesByType);

        //把各个类型的菜的卡路里求和
        Map<Dish.Type, Integer> totalCalorieByType = menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(totalCalorieByType);

        //与groupingBy联用常常与mapping方法生成
        Map<Dish.Type, Set<Dish.CaloricLevel>> calorieLevelsByType = menu.stream().collect(groupingBy(Dish::getType, mapping(d -> {
            if (d.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if (d.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        }, toSet())));

        //把lambda表达式转换成方法引用，在Dish中添加一个方法getCaloricLevel()
        Map<Dish.Type, Set<Dish.CaloricLevel>> calorieLevelsByType1 = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getCaloricLevel, toSet())));

        System.out.println(calorieLevelsByType);

        calorieLevelsByType = menu.stream().collect(groupingBy(Dish::getType,mapping(d -> {
            if(d.getCalories() <= 400) return Dish.CaloricLevel.DIET;
            else if(d.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
            else return Dish.CaloricLevel.FAT;
        },toCollection(HashSet::new))));

        System.out.println(calorieLevelsByType);

        //分区，分组的特殊情况，分区函数返回一个布尔值，因此只会有两种结果,下面把菜分为素菜和荤菜
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        //先把菜分成素与荤两组，然后再按类型分类
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianByType = menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(vegetarianByType);

        //查找素食和非素食最高热量的菜
        Map<Boolean, Dish> mostCaloriesByVegetarian = menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloriesByVegetarian);

        //计算素菜和荤菜卡路里大于500的分类
        Map<Boolean, Map<Boolean, List<Dish>>> dishByVegetaianAndCalories = menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));
        System.out.println(dishByVegetaianAndCalories);

        //计算素菜和荤菜分别有多少个
        Map<Boolean, Long> countDishByVegetarian = menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(countDishByVegetarian);

        Map<Boolean, List<Integer>> map = partitionPrime(100);
        System.out.println(map.get(true));
        long sum = countPrime(1, 100);
        System.out.println(sum);

    }

    private static boolean isPrime(int candidate){
        int candidateRoot = (int)Math.sqrt(candidate);
        return IntStream.rangeClosed(2,candidateRoot).noneMatch(i -> candidate%i == 0);
    }
    private static Map<Boolean, List<Integer>> partitionPrime(int i){
        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, i).boxed().collect(partitioningBy(candidate -> isPrime(candidate)));
        return map;
    }

    private static long countPrime(int start,int end){
         return IntStream.rangeClosed(start,end).filter(i -> isPrime(i)).count();
    }
}
