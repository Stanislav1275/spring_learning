package classes;

import Annotations.ToString;
import org.springframework.stereotype.Component;


public class Cat {
    public String mew(){
        return "meow";
    }

   Integer age = 5;

    public Cat(int age){
        this.age = age;
    }


}
