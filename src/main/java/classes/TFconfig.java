package classes;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@ComponentScan("classes")
@Configurable

public class TFconfig {
    @Bean
    public Map<String, String> colorList (){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("red", "yellow");
        map.put("yellow", "green");
        map.put("green", "yellow_green");
        map.put("yellow_green", "red");
        map.put("black", "black");
        return map;
    }

}
