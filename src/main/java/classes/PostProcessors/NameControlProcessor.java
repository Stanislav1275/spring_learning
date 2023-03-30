package classes.PostProcessors;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
@ComponentScan("java")
public class NameControlProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try {
            Field field = bean.getClass().getDeclaredField("name");
            field.setAccessible(true);
            Object val = ReflectionUtils.getField(field, bean);
            if (field.getType() == String.class && val == null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, "катя");
            }
        } catch (NoSuchFieldException ignored) {
//
        }
        return bean;
    }
}
