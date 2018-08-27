package LambdaExample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        for (int i=100;i<200;i=i+10){
            Apple apple;
            if(i%2==0) {
                 apple = new Apple("red", i);
            }else {
                 apple = new Apple("green",i);
            }
            appleList.add(apple);
        }

        //使用匿名类实现排
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(appleList);

        //使用lambda表达式
        appleList.sort((Apple o1,Apple o2) -> o1.getWeight().compareTo(o2.getWeight()));

        //使用方法引用
        Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
        appleList.sort(c);
        appleList.sort(Comparator.comparing(Apple::getWeight));//按重量排序
        System.out.println("1:"+appleList);
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed());//按重量反向排序
        System.out.println("2:"+appleList);
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));//按重量排完按颜色排

        Predicate<Apple> redp = (Apple a) ->"red".equals(a.getColor());//是红苹果
        Predicate<Apple> notRedp = redp.negate();//不是红苹果
        Predicate<Apple> p = notRedp.and((Apple a) -> a.getWeight() > 150).or(apple -> "blue".equals(apple.getColor()));

    }
}
