package model.FactoryModel;

import com.sun.javafx.collections.MappingChange;

import java.util.*;
import java.util.function.Supplier;

public class ProductFactory {
//    public static Product createProduct(String name){
//        switch (name){
//            case "Loan": {return new Loan();}
//            case "Stock":{return new Stock();}
//            case "LoaBondn" :{return new LoaBondn();}
//            default:throw new RuntimeException("no such product："+name);
//
//        }
//    }

    public static void main(String[] args) {
        Product p = createProduct("Loan");
        System.out.println(p);
    }

    //使用Lambda表达式实现工厂模式
    final static Map<String, Supplier<Product>> map = new HashMap<String, Supplier<Product>>();
    static {
        map.put("Loan",Loan::new);
        map.put("Stock",Stock::new);
        map.put("LoaBondn",LoaBondn::new);
    }

    public static Product createProduct(String name){
        Supplier<Product> supplier = map.get(name);
        if(supplier != null){
            return supplier.get();
        }
        throw new RuntimeException("No such Product: "+name);
    }

}
