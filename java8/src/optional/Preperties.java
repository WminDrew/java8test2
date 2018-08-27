package optional;
import java.util.*;

public class Preperties {
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(String key, String value) {
        this.property = new Property(key,value);
    }
}
