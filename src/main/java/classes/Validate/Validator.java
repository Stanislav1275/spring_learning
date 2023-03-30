package classes.Validate;


import Annotations.Configurationable;
import Annotations.Validate;
import Interfaces.ValidCallback;
import classes.CustomError.ValidateException;
import classes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.module.Configuration;
import java.sql.Ref;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

@Component
public class Validator {
    @Autowired
    ApplicationContext ctx;

    public void validate(Object testable, String beanName) {
        Map<String, ValidateException> res = new HashMap<>();
        Class<?> clazz = testable.getClass();
        if (clazz.isAnnotationPresent(Validate.class)) {
            String[] testes = clazz.getAnnotation(Validate.class).value();
            for (String testName : testes) {
                try {
                    Object maybeConfig = ctx.getBean(testName);
                    Class<?> clazzConfig = maybeConfig.getClass();
                    ReflectionUtils.doWithMethods(clazzConfig, method -> {
                        if (method.getReturnType().equals(ValidateException.class)) {
                            ReflectionUtils.makeAccessible(method);
                            ValidateException v = (ValidateException) ReflectionUtils.invokeMethod(method, maybeConfig, testable);
                            if (v != null) {
                                res.put(beanName + ":" + method.getName(), v);
                            }
                        }
                    });
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (res.size() != 0) {
                    System.out.println(res);
                }

            }
        }
    }
}
