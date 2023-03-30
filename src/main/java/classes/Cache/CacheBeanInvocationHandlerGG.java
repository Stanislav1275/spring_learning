package classes.Cache;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheBeanInvocationHandlerGG implements InvocationHandler {
    Object bean;
    List<String> methodNamesCache;
    boolean isModify = true;
    Map<String, Object> cacheMethods = new HashMap<>();

    public CacheBeanInvocationHandlerGG(Object bean, List<String> methodNamesCache) {
        this.bean = bean;
        this.methodNamesCache = methodNamesCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (methodNamesCache.size() == 0) return method.invoke(bean, args);
        String cachedMethod = methodNamesCache.stream().filter(s -> s.equals(method.getName())).toList().get(0);
        Object invokeRes;
        if (cachedMethod.equals(method.getName()))
            if (isModify) {
                invokeRes = method.invoke(bean, args);
                cacheMethods.put(method.getName(), invokeRes);
                isModify = false;
                return invokeRes;
            } else {
                if (cacheMethods.containsKey(method.getName())) {
                    System.out.println("взят из кеша");
                    invokeRes = method.invoke(bean, args);
                    cacheMethods.put(method.getName(), invokeRes);
                    return invokeRes;
                }
                return cacheMethods.get(method.getName());
            }
        return method.invoke(bean, args);
    }
}
