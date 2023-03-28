package classes.DefaultReset;

import classes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
@ComponentScan("classes")
public class DefaultConfig2 {
    @Bean
    String studentName(){
     return "василий";
    }
    @Bean
    Student<Integer> defSt(){
        return new Student<>("катя", x -> x > 0 && x < 6, 5,5,5,5);
    }
}
