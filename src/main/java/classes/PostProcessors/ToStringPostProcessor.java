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
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.module.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//@Component
@Order(5)
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
//            return Proxy.newProxyInstance(
//                    clazz.getClassLoader(),
//                    clazz.getInterfaces(),
//                    new TostringProxy(bean)
//            );
//            Class<?> [] classes = clazz.getConstructors()[0].getParameterTypes();
////            Class<?> [] classes = Arrays.stream(clazz.getDeclaredFields()).map(Field::getType).toArray(Class<?>[]::new);
//            Object[] objects = Arrays.stream(clazz.getDeclaredFields()).map(field -> {
//                ReflectionUtils.makeAccessible(field);
//                return ReflectionUtils.getField(field, bean);
//            }).toArray(Object[]::new);
//            System.out.println(Arrays.toString(classes));
//            System.out.println(Arrays.toString(objects));
//            System.setProperty("net.sf.cglib.core.AnnotationVisibility", "true");
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(clazz);
//            clazz.getAnnotations();
//            enhancer.setCallback(new TostringProxy(bean));
//            enhancer.setContextClass(clazz);

            return   Enhancer.create(
                    clazz, clazz.getInterfaces(), new TostringProxy(bean)
            );
//
//            bean = Enhancer.create(clazz, new TostringProxy(bean));
            //        ClassA a = (ClassA) enhancer.create(new Class[] {ClassB.class}, new Object[] {new ClassB()});

        }

        return bean;
    }
}
