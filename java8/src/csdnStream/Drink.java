package csdnStream;

public class Drink {
    private String name;
    private Type type;
    private int Calorie;

    public Drink() {
    }

    public Drink(String name, Type type, int calorie) {
        this.name = name;
        this.type = type;
        Calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getCalorie() {
        return Calorie;
    }

    public void setCalorie(int calorie) {
        Calorie = calorie;
    }

    public enum Type{
        CARBONIC_ACID,FRUIT_JUICE,TEA,MILK
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", Calorie=" + Calorie +
                '}';
    }
}
