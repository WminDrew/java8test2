public class MeaningOfThis {
    public final int value = 10;
    public void doIt(){
        int value = 9;
        Runnable r = new Runnable() {
            public final int value = 8;

            @Override
            public void run() {
                int value = 7;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
