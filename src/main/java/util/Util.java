package util;

import classes.Invoke;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Stream;

public class Util {
    public static Field[] getFieldCollection(Object o) {
        Class<?> clazz = o.getClass();
        return
                Stream.concat(
                        Arrays.stream(clazz.getDeclaredFields()),
                        Arrays.stream(clazz.getFields()).filter(field -> !Modifier.isPublic(field.getModifiers()))
                ).toArray(Field[]::new);

    }

    @SneakyThrows
    public static Map<String, Object> collect(Class<?>... classes) {
        Map<String, Object> objects = new HashMap<>();
        for (Class<?> clazz : classes) {
            Object object = clazz.getConstructor().newInstance();
            Arrays.stream(clazz.getDeclaredMethods())
                    .filter(method ->
                            !method.getReturnType().equals(Void.TYPE) &&
                                    method.isAnnotationPresent(Invoke.class) &&
                                    method.getParameterTypes().length == 0
                    )
                    .forEach(method -> {
                        method.setAccessible(true);
                        try {
                            objects.put(method.getName(), method.invoke(object));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        return objects;
    }

    @SneakyThrows
    public static Map<String, Object> nCollect(Class<?> clazz) {
        Map<String, Object> objects = new HashMap<>();
        objects = collect(clazz);
        List<Object> waiters = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (!(objects.containsKey(method.getName()))) {
                if (method.isAnnotationPresent(Invoke.class) && method.getReturnType() != Void.TYPE) {
                    Class<?>[] params = method.getParameterTypes();

                    System.out.println(Arrays.toString(params));

                }
            }
        }
        return objects;
    }
    @SneakyThrows
    //вернутьЗначенияДляМетодаИзМапыМетодов
    public Class<?>[] findDefParamsInMap(HashMap<String, Object> methodsMap,  Method method, Class<?> clazz) {
        Class<?>[] params = method.getParameterTypes();

        int count = 0;
        for (Map.Entry<String, Object> objectEntry : methodsMap.entrySet()) {
            for (Class<?> param : params) {
                Method methodFromMap = clazz.getDeclaredMethod(objectEntry.getKey());
                if (methodFromMap.getReturnType().equals(param)) {//если параметр совпадет
                    count++;
                }
            }
        }
        return null;
    }

}
