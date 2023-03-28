package classes.PostProcessors;

import classes.Student;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
public class HumanHandler implements InvocationHandler {
    Student<?> st;

    public HumanHandler(Student<?> st) {
        this.st = st;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("привет");
        return method.invoke(st, args);
    }
}
