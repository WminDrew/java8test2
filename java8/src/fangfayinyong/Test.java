package fangfayinyong;

public class Test {
    public static void main(String[] args) {
        TriFunction<String,String,String,Color> tf = Color::new;
        Color a = tf.apply("x", "y", "z");
        System.out.println(a);
    }
}
