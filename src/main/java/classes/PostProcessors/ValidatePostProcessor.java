package classes.PostProcessors;

import Annotations.Validate;
import classes.Validate.Validator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ValidatePostProcessor implements BeanPostProcessor {
    @Autowired
    Validator validator;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(!bean.getClass().isAnnotationPresent(Validate.class)){
            return bean;
        }
        validator.validate(bean, beanName);
        return bean;
    }
}
