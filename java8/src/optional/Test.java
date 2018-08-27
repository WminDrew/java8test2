package optional;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import stream.Dish;

import java.security.PublicKey;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Insurance insurance = new Insurance("平安保险");
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        name.ifPresent(System.out::println);

        Car car = new Car();
        Person p = new Person(car);
        Optional<Person> optPerson = Optional.ofNullable(p);
        String insuranceName = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("UnKnown");
        System.out.println(insuranceName);
//         insuranceName = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElseThrow(()->new MyException("null的时候故意抛出的提示异常"));
//        System.out.println(insuranceName);

        Optional.ofNullable(insurance).filter(in -> "平安保险".equals(in.getName())).ifPresent(x-> System.out.println(x.getName()+"ok"));
        Optional<Integer> result = new Test().stringToInt("s2232");
        result.ifPresent(System.out::println);
    }

    public Insurance findCheapestInsurance(Person person,Car car){
        return new Insurance("cheapestCompany");
    }

    //找出最便宜的保险公司
    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person,Optional<Car> car){
        if(person.isPresent() && car.isPresent()){
            return Optional.of(findCheapestInsurance(person.get(),car.get()));
        }else {
            return Optional.empty();
        }
    }

    //找出年龄大于或者更等于minAge的员工所对应的保险公司列表
    public String getCarInsuranceName(Optional<Person> person ,int minAge){
        return person.filter(p -> p.getAge()> minAge)
                .flatMap(p -> p.getCar())
                .flatMap(c ->c.getInsurance())
                .map(i -> i.getName())
                .orElse("UnKnow");
    }

    public Optional<Integer> stringToInt(String s){
        try {
            return Optional.ofNullable(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
