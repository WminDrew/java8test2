package csdnLambda;

import LambdaExample.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        Fruit apple = new Fruit("red", 150, "apple");
        Fruit banana = new Fruit("yellow", 90, "banana");
        Fruit sydney = new Fruit("green", 180, "sydney");

        fruitList.add(apple);
        fruitList.add(banana);
        fruitList.add(sydney);

        List<Fruit> redFruitList = getFruitByColor(fruitList, "red");
        //匿名内部类
        List<Fruit> redFruitList1 = getFruit(fruitList, new Predicate<Fruit>() {
            @Override
            public boolean test(Fruit fruit) {
                return "red".equals(fruit.getColor());
            }
        });

        getFruit(fruitList,(Fruit f) -> "red".equals(f.getColor()));
        filter(fruitList,a ->"green".equals(a.getColor()));
        filter(fruitList, new FruitPredicate<Fruit, Boolean>() {
            @Override
            public Boolean test(Fruit fruit) {
                return "green".equals(fruit.getColor());
            }
        });

        Predicate<Fruit> predicate = f -> "green".equals(f.getColor());

    }

    public static List<Fruit> getFruitByColor(List<Fruit> list,String color){
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : list){
            if (color.equals(fruit.getColor())){
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public static List<Fruit> getFruit(List<Fruit> list, Predicate<Fruit> p){
        List<Fruit> fruitList = new ArrayList<>();
        for (Fruit fruit : fruitList){
            if(p.test(fruit)){
                fruitList.add(fruit);
            }
        }
        return fruitList;
    }

    public static List<Fruit> filter(List<Fruit> inventory,FruitPredicate<Fruit,Boolean> fp){
        List<Fruit> result = new ArrayList<>();
        for (Fruit f : inventory){
            if(fp.test(f)){
                result.add(f);
            }
        }
        return result;
    }
}
