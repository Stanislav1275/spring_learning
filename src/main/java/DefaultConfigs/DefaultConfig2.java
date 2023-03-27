package DefaultConfigs;

import classes.Student;
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
    Student defStudent(String studentName, Predicate<Integer> range){
        return new Student(studentName, range);
    }
}
