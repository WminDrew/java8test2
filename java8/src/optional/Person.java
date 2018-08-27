package optional;

import java.util.Optional;

public class Person {
    private Car car;
    private int age;

    public Person() {
    }

    public Person(Car car) {
        this.car = car;
    }

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
