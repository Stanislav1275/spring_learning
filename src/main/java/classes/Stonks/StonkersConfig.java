package classes.Stonks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;


@Configuration
@ComponentScan("classes")
public class StonkersConfig {
    @Bean
//    @Lazy
    public Stonker st1(){
        Stonker st = new Stonker(null, "s1", "s2");
        return st;
    }
    @Bean
//    @Lazy
    public Stonker st2(){
        Stonker st = new Stonker("st2", "s1");
        return st;
    }
    @Bean
    @Autowired
    public StonkCastle stonkCastle(List<StonkListenner> listeners){
        return new StonkCastle(listeners);
    }
}
