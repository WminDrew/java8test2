package model.strategyMode;

public class Test {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbbbbbbbbbbb");
        System.out.println("b1: "+b1+", b2: "+b2);

        //使用Lambda表达式可以不用写实现类isAllLowerCase和isNumeric
        Validator lowerCaseValidator1 = new Validator((String s) -> s.matches("[a-z]+"));
        Validator numericValidator1 = new Validator((s) -> s.matches("\\d+"));
    }
}
