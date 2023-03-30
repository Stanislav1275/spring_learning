package DefaultConfigs;

import Annotations.Configurationable;
import Interfaces.ValidCallback;
import classes.CustomError.ValidateException;
import classes.Student;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public class StudentValidate{
    public ValidateException validName(Student<?> st){
        return !st.getName().equals("нец.слово")?null:new ValidateException("в имени не должны быть такие слова");
    }
    public ValidateException sexAccessible(Student<?> st){
        return !st.getName().endsWith("я")?null:new ValidateException("среди нас, возможно, девочка, парни, ведите себя прилично!");
    }

}
