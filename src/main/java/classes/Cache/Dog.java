package classes.Cache;

import org.springframework.stereotype.Component;

@Component
@Cache({})
public class Dog {
    public int getAge(){
        System.out.println("origin age = 10");
        return 10;
    }
}
