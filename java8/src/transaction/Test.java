package transaction;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Test {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alen = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300,"dollar"),
                new Transaction(raoul, 2012, 1000,"GBP"),
                new Transaction(raoul, 2011, 400,"EUR"),
                new Transaction(mario, 2012, 710,"franc"),
                new Transaction(mario, 2012, 700,"dollar"),
                new Transaction(alen, 2012, 950,"franc")
        );

        //找出2012年发生的交易，并按交易额排序（从低到高）。
//        List<Transaction> list = transactions.stream().filter(t -> t.getYear() == 2012).sorted((t1, t2) -> t1.getValue() - t2.getValue()).collect(toList());
//        list.forEach(System.out::println);
//        list = transactions.stream().filter(t -> t.getYear() == 2012).sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
//        list.forEach(System.out::println);

        //交易员都在哪些不同的城市工作过
//        List<String> list = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());
//        list.forEach(System.out::println);
//        Set<String> set = transactions.stream().map(t -> t.getTrader().getCity()).collect(toSet());
//        set.forEach(System.out::println);

        //查找来之与剑桥的交易员,并按姓名排序
//        List<Trader> list = transactions.stream().map(t -> t.getTrader()).filter(t -> "Cambridge".equals(t.getCity())).distinct().sorted(Comparator.comparing(Trader::getName)).collect(toList());
//        System.out.println(list);

        //返回所有交易者名字的字符串，并按字母排序
//        String list = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(joining());
//        System.out.println(list);

        //有没有交易员在米兰工作的
//        boolean result = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
//        System.out.println(result);

        //交易中最高的交易额
//        Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
//        maxValue.ifPresent(System.out::println);

        //找到最小的交易额的交易
//        Optional<Transaction> result = transactions.stream().reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t2 : t1);
//        result.ifPresent(System.out::println);
//        Optional<Transaction> result1 = transactions.stream().min(comparing(Transaction::getValue));
//        result1.ifPresent(System.out::println);


    }
}
