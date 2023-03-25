package classes;
import classes.Colors.Colorable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Scope("prototype")
public class TrafficLight {
    Colorable cur;
    @Autowired
    @Qualifier("black")
    Colorable offColor;
    Colorable endColor;

    @Autowired
    TrafficLight(@Autowired Colorable red) {
        this.cur = red;
        endColor = red;
    }

    public void next() {
        System.out.println(cur);
        cur = cur.getNext();
        if(cur != offColor)
            endColor = cur;
    }

    public void off() {
        cur = offColor;
    }

    public void on() {
        cur = endColor;
    }
}
