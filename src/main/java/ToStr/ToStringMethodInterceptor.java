package ToStr;


import Annotations.ToString;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class ToStringMethodInterceptor implements InvocationHandler {

    private Object target;

    public ToStringMethodInterceptor(Object target) {
        this.target = target;
    }

    public static Object createProxy(Object target) {
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), interfaces, new ToStringMethodInterceptor(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (method.getName().equals("toString")) {
//            ToString annotation = target.getClass().getAnnotation(ToString.class);
//            if (annotation != null) {
//                StringBuilder sb = new StringBuilder(target.getClass().getSimpleName() + " {");
//                Method[] methods = target.getClass().getMethods();
//                for (Method m : methods) {
//                    if (m.getName().startsWith("get") && !m.getName().equals("getClass")) {
//                        Object value = m.invoke(target);
//                        sb.append(m.getName().substring(3)).append("=").append(value).append(", ");
//                    }
//                }
//                sb.delete(sb.length() - 2, sb.length()).append("}");
//                return sb.toString();
//            }
//        }
        return method.invoke(target, args);
    }
}


