package spring;

import classes.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Configuration
@ComponentScan("classes")

public class Config {
    @Bean
    int max() {
        return 3;
    }

    @Bean
    int min() {
        return 1;
    }

    @Bean
    int age() {
        return 18;
    }

    @Bean
    @Scope("prototype")
    int random(Rnd rnd) {
        return rnd.rnd();
    }
    @Bean
    Feedback veryGoodFeedBack(){
        return new Feedback("очень", 4);
    }
    @Bean
    Feedback GoodFeedBack(){
        return new Feedback("сойдёт", 3);
    }
    @Bean
    Feedback sosoFeedBack(int random){
        return new Feedback("сложно сказать", random);
    }
    @Bean
    Feedback bestFeedBack(List<Feedback> fbs){
        return fbs.stream().max(Comparator.comparing(Feedback::getRate)).get();
    }
    @Bean
    Predicate<Integer> range(){
        return (x) -> (x >= 1 && x <= 5);
    }
    @Bean
    Student<Integer> getBadSt(@Qualifier("range") Predicate<Integer> range){
        return new Student<Integer>("хороший студент", range, 5,4,3,5);
    }
    @Bean
    @Lazy
    Student<Integer> getGoodSt(@Qualifier("range") Predicate<Integer> range){
        return new Student<Integer>(null, range, 3,3,2,3);
    }
    @Bean
    StudentBuilder studentBuilder(){
        return new StudentBuilder();
    }

    @Bean
    public Shit shit() {
        return new Shit();
    }

}
