package classes.Colors;

import org.springframework.stereotype.Component;

@Component
public class Black implements  Colorable{
    @Override
    public String toString() {
        return "black";
    }

    @Override
    public Colorable getNext() {
        return this;
    }
}
