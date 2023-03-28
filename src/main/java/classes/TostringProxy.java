package classes;

import Annotations.ToString;
import lombok.SneakyThrows;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Ref;

public class TostringProxy implements InvocationHandler {
    private final Object bean;

    public TostringProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    @SneakyThrows
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("toString")) {
            ToString annotation = bean.getClass().getAnnotation(ToString.class);
            if (annotation != null) {
                StringBuilder sb = new StringBuilder(bean.getClass().getSimpleName() + " {");
                ReflectionUtils.doWithLocalFields(bean.getClass(), field -> {
                    field.setAccessible(true);
                    sb.append(field.getName() + "=" + field.get(bean) + " ");
                });
                sb.append("}");
                return sb.toString();
            }
        }
        return method.invoke(proxy, args);
    }
}
