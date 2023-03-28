package ToStr;

import classes.Entity;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class EntityHandler implements InvocationHandler {
    private Entity entity;
    private List<Field> fields;

    public EntityHandler(Entity entity,List<Field> fields) {
        this.entity = entity;
        this.fields.addAll(fields);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (method.getName().equals("toString")){
//            String temp = proxy.getClass() + "{ ";
//            for (Field field:
//                    fields) {
//                temp+= field.getName() + " : " + field.get(proxy);
//            }
//            return temp +"}";
//        }
        return method.invoke(entity, args);
    }
}
