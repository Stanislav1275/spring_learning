package classes.Streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

@Configuration
public class StreamingConfig {
    @Bean
    String readFileName() {
        return "src/main/java/classes/Streaming/test";
    }

    @Bean
    String writeFileName() {
        return "src/main/java/classes/Streaming/test";
    }

    @Bean
    @Order(1)
    Writerable a1() {
        return data -> Arrays.stream(data).map(String::toUpperCase).toArray(String[]::new);
    }

    @Bean
    @Order(2)
    Writerable a2() {
        return data -> Arrays.stream(data).map(str -> str.replaceAll("A", "")).toArray(String []::new);
    }

    @Bean
    @Order(3)
    Writerable a3() {
        return data -> Arrays.stream(data).filter(el -> el.length() > 4).toArray(String[]::new);

    }


}
