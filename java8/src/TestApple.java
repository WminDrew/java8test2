import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TestApple {

    //筛选绿色苹果
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    //筛选出重的苹果
    public static List<Apple> filterHeavyApple(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if(apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    //以java8思想来写
    static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple:inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory,AppleFormatter formatter){
        for (Apple apple : inventory){
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    //更加抽象的filter
    public static <T> List<T> filter(List<T> list,AllPredicate<T> ap){
        List<T> result = new ArrayList<>();
        for (T e:list){
            if(ap.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple = new Apple(130,"green");
        Apple apple1 = new Apple(160,"red");
        Apple apple2 = new Apple(200,"green");
        inventory.add(apple);
        inventory.add(apple1);
        inventory.add(apple2);
//        inventory.stream().filter((Apple a) -> a.getWeight() > 150 && "green".equals(a.getColor())).forEach(System.out::println);
//        filterApples(inventory,Apple::isHeavyApple);
        List<Apple> appleList = filterApples(inventory, new AppleGreenColorPredicate());
        System.out.println("颜色是绿色的苹果："+appleList);
        //使用匿名类筛选出红色苹果
        appleList = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        System.out.println("颜色是红色的苹果："+appleList);
        appleList = filterApples(inventory,new AppleHeavyWeightPredicate());
        System.out.println("重量超过150的苹果："+appleList);
        //使用lambda表达式筛选出超过200的苹果
        filterApples(inventory,(Apple a) -> a.getWeight()>200);
        //打印出apple的重量
        prettyPrintApple(inventory,new AppleSimpleFormatter());

        //使用更加抽象的AllPredicate,不仅仅限于筛选苹果
        appleList= filter(inventory, new AllPredicate<Apple>() {
            @Override
            public boolean test(Apple a) {
                return "green".equals(a.getColor());
            }
        });

        List numList  = Arrays.asList(1,13,2,4,11,35,67);
        List evenList = filter(numList, new AllPredicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i % 2 == 0;
            }
        });
        System.out.println("偶数："+evenList);
        filter(inventory,(Apple a) -> a.getWeight()>150);
       inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return (int)(o1.getWeight()-o2.getWeight());
            }
        });
       inventory.forEach(System.out::println);
    }

    Comparator<Apple> comparator = new Comparator<Apple>() {
        @Override
        public int compare(Apple o1, Apple o2) {
            return (int) (o1.getWeight()-o2.getWeight());
        }
    };
    //lambda表达式
    Comparator<Apple> comparator1 = (Apple a1,Apple a2) -> (int)( a1.getWeight()-a2.getWeight());
}
