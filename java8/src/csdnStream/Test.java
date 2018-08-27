package csdnStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Test {
    public static void main(String[] args) {
        List<Drink> drinkList = Arrays.asList(
                new Drink("cocaCalo", Drink.Type.CARBONIC_ACID, 300),
                new Drink("sprite", Drink.Type.CARBONIC_ACID, 330),
                new Drink("fanta", Drink.Type.FRUIT_JUICE, 350),
                new Drink("mintueMaid", Drink.Type.FRUIT_JUICE, 430),
                new Drink("coconut", Drink.Type.FRUIT_JUICE, 370),
                new Drink("yiLi", Drink.Type.MILK, 550),
                new Drink("wangZai", Drink.Type.MILK, 500),
                new Drink("IcedRedTea", Drink.Type.TEA, 280),
                new Drink("greenTea", Drink.Type.TEA, 250)
        );
        //找出卡路里大于350的所有饮料
        List<Drink> newList = new ArrayList<>();
        for (int i = 0; i < drinkList.size(); i++) {
            if (drinkList.get(i).getCalorie() > 350) {
                newList.add(drinkList.get(i));
            }
        }

        List<Drink> list = drinkList.stream().filter(d -> d.getCalorie() > 350).collect(toList());
        System.out.println(list);

        //转换成流
        Stream<Drink> stream1 = drinkList.stream();
        //筛选filter
        Stream<Drink> stream2 = drinkList.stream().filter(d -> d.getCalorie() > 350);
        //map
        Stream<String> stream3 = drinkList.stream().filter(d -> d.getCalorie() > 350).map(d -> d.getName());
        //limit()
        Stream<String> stream4 = drinkList.stream().filter(d -> d.getCalorie() > 350).map(d -> d.getName()).limit(3);
        //skip()
        Stream<Drink> stream5 = drinkList.stream().filter(d -> d.getCalorie() > 350).skip(2);
        //collect()
        List<String> list1 = drinkList.stream().filter(d -> d.getCalorie() > 350).map(d -> d.getName()).skip(2).limit(3).collect(toList());
        //count()
        long count = drinkList.stream().filter(d -> d.getCalorie() > 500).count();

        //flatMap();
        List<String> list2 = Arrays.asList("Hello", "World");
        List<String> list3 = list2.stream().map(str -> str.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(list3);
        String[] strs = new String[]{"Hello"};
        Stream<String> stream7 = Arrays.stream(strs);

        //找出一瓶属于茶类的饮料
        Optional<Drink> tea = drinkList.stream().filter(d -> Drink.Type.TEA.equals(d.getType())).findAny();
        tea.ifPresent(t -> System.out.println(t));

        Optional<Drink> result = drinkList.stream().filter(d -> d.getCalorie() > 450).findFirst();
        result.ifPresent(System.out::println);

        boolean b1 = drinkList.stream().anyMatch(d -> d.getCalorie() > 500);
        boolean b2 = drinkList.stream().allMatch(d -> d.getCalorie() > 500);
        boolean b3 = drinkList.stream().noneMatch(d -> d.getCalorie() > 500);
        System.out.println("b1：" + b1 + " ,b2: " + b2 + "b3: " + b3);

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = intList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        Integer max = intList.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(max);
        Integer min = intList.stream().reduce(0, (a, b) -> a > b ? b : a);
        System.out.println(min);
        Optional<Integer> min1 = intList.stream().reduce((a, b) -> a > b ? b : a);
        min1.ifPresent(System.out::println);

        Integer calorieSum = drinkList.stream().map(d -> d.getCalorie()).reduce(0, Integer::sum);
        System.out.println("calorieSum: " + calorieSum);
        int calorieSum1 = drinkList.stream().mapToInt(d -> d.getCalorie()).sum();
        drinkList.stream().mapToInt(d -> d.getCalorie()).max();

        //求勾股数
        Stream<int[]> gouGuShu = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(i -> IntStream.rangeClosed(i, 100).filter(j -> (Math.sqrt(i * i + j * j)) % 1 == 0)
                        .mapToObj(j -> new int[]{i, j, (int) Math.sqrt(i * i + j * j)}));
        List<int[]> gouGuShuList = gouGuShu.limit(5).collect(Collectors.toList());
        gouGuShuList.forEach(g -> System.out.println(Arrays.toString(g)));

        //找出卡路里最大的饮料
        Optional<Drink> maxCalorieDrink = drinkList.stream().collect(maxBy(Comparator.comparing(Drink::getCalorie)));
        maxCalorieDrink.ifPresent(System.out::println);
        Integer sumCalories = drinkList.stream().collect(summingInt(Drink::getCalorie));
        Double averageCalorie = drinkList.stream().collect(averagingInt(Drink::getCalorie));
        System.out.println(sumCalories);

        String drinkName = drinkList.stream().map(d -> d.getName()).collect(Collectors.joining("+"));
        System.out.println(drinkName);

        Integer sumCalories1 = drinkList.stream().collect(reducing(0, Drink::getCalorie, (a, b) -> a + b));
        System.out.println(sumCalories1);

        Map<Drink.Type, List<Drink>> drinkByType = drinkList.stream().collect(groupingBy(Drink::getType));
        System.out.println(drinkByType);
        Map<String, List<Drink>> drinkByCalorie = drinkList.stream().collect(groupingBy(drink -> {
            if (drink.getCalorie() > 400) return "Hiht";
            else return "Low";
        }));

        System.out.println(drinkByCalorie);

        Map<String, Map<Drink.Type, List<Drink>>> drinkByCalorieAndType = drinkList.stream().collect(groupingBy(drink -> {
            if (drink.getCalorie() > 400) return "Higt";
            else return "Low";
        }, groupingBy(Drink::getType)));

        System.out.println(drinkByCalorieAndType);
    }

}
