package classes;

import Annotations.StringsVariants;
import Annotations.ToString;
import Annotations.newDefault;
import classes.Human;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
//@newDefault(beanName = "defStudent")
//@newDefault(beanName = "defSt")
@ToString
@NoArgsConstructor
public class Student<T>{
//    @newDefault(beanName = "studentName")
    private String name;
    private List<T> grades = new ArrayList<>();
    private Predicate<T> rule;

    @SafeVarargs
    public Student(String name, Predicate<T> rule, T... grades) {
        setName(name);
        setRule(rule);
        addGrades(grades);
    }

    public Student(String name, Predicate<T> rule) {
        this(name, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getGrades() {
        return grades;
    }


    @SafeVarargs
    public final void addGrades(T... grades) {
        for(T grade : grades) {
            if(rule.test(grade)){
                this.grades.add(grade);
            }else throw new IllegalArgumentException("grade is not valid");
        }
    }

    public Predicate<T> getRule() {
        return rule;
    }

    public void setRule(Predicate<T> rule) {
        this.rule = rule;
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", grades=" + grades +
//                '}';
//    }
}
