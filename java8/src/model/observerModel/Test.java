package model.observerModel;

public class Test {
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObserver("The queen said her favourite book is Java 8 in Action");
        f.notifyObserver("i love money");

        //使用Lambda表达式不需要写实现Observer接口的类
        f.registerObserver((String tweet) ->{
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY!"+tweet);
            }
        });
    }
}
