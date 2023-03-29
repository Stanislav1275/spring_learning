package classes.PostProcessors;

import Annotations.ToString;
import ToStr.EntityHandler;
import ToStr.ToStringMethodInterceptor;
import classes.Cat;
import classes.Entity;
import classes.Student;
import classes.TostringProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component

public class ToStringPostProcessor implements BeanPostProcessor {
    Map<String, Class<?>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(ToString.class))
            map.put(beanName, clazz);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = map.get(beanName);

        if (clazz != null) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(new TostringProxy(bean));
            enhancer.setInterceptDuringConstruction(false);
            return  clazz.cast(enhancer.create());
//
//            bean = Enhancer.create(clazz, new TostringProxy(bean));
            //        ClassA a = (ClassA) enhancer.create(new Class[] {ClassB.class}, new Object[] {new ClassB()});

        }

        return bean;
    }
}
