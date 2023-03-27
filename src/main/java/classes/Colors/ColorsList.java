package classes.Colors;

import classes.Colors.Color;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan("classes")

public class ColorsList {
    @Bean
    public Colorable red(Colorable yellow){
        return new Colorable() {
            @Override
            public Colorable getNext() {
                return yellow;
            }

            @Override
            public String toString() {
                return "red";
            }
        };
    }
    @Bean
    public Colorable yellow(@Lazy Colorable green){
        return new Colorable() {
            @Override
            public Colorable getNext() {
                return green;
            }

            @Override
            public String toString() {
                return "yellow";
            }
        };
    }
    @Bean
    public Colorable green(Colorable yellow_green){
        return new Colorable() {
            @Override
            public Colorable getNext() {
                return yellow_green;
            }

            @Override
            public String toString() {
                return "green";
            }
        };
    }
    @Bean
    public Colorable yellow_green(Colorable red){
        return new Colorable() {
            @Override
            public Colorable getNext() {
                return red;
            }

            @Override
            public String toString() {
                return "yellow_green";
            }
        };
    }
}