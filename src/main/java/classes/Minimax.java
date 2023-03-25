package classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
@Component
public class Minimax {
    @Autowired
    public int min;
    @Autowired
    public  int max;
    @PostConstruct
    void init (){
        if(min > max) throw new IllegalArgumentException("min > max");
    }
}
