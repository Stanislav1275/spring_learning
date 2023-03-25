package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class StudentBuilder {
    private Predicate<Integer> range;
    public Student<Integer> create(String name, Integer ...grades){
        return new Student<>(name, range, grades);
    }
    public Student<Integer> create(String name){
        return new Student<>(name, range, null);
    }
    @Autowired
    public void setRange(Predicate<Integer> range) {
        this.range = range;
    }
}
