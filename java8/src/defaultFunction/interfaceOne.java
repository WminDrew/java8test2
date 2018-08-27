package defaultFunction;

public interface interfaceOne {
    default void print(){
        System.out.println("default function in interface");
    };

    static void pringTwo(){
        System.out.println("static function in interface");
    }
}