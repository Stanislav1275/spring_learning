package classes.PostProcessors;

import classes.Cache.Cache;
import classes.Cache.CacheBeanInvocationHandlerGG;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CacheMethodBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if(!clazz.isAnnotationPresent(Cache.class)) return bean;
        List<String> methodsForCache = new ArrayList<>(Arrays.asList(clazz.getAnnotation(Cache.class).value()));
        if(methodsForCache.size() == 0){
            for (Method method : clazz.getDeclaredMethods()){
                method.setAccessible(true);
                System.out.println("кешировано");
                System.out.println(method.getName());
                System.out.println("----------");
                if(method.getParameterCount() == 0) methodsForCache.add(method.getName());
            }
//            ReflectionUtils.doWithMethods(clazz, method -> {

//            });
        }
        System.out.println(methodsForCache);
        bean = Enhancer.create(
                clazz,
                new CacheBeanInvocationHandlerGG(bean, methodsForCache)
        );
        return bean;
    }
}
