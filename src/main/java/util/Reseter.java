package util;

;

import Annotations.newDefault;
import classes.Default;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Component
public class Reseter {

    public static void reset(Object o) throws FileNotFoundException, IllegalAccessException {
        Gson gson = new Gson();
        JsonObject jsonObject;
        if (o.getClass().isAnnotationPresent(Default.class)) {
            jsonObject = (JsonObject) new JsonParser().parse(new FileReader(o.getClass().getAnnotation(Default.class).value()));
            JsonObject oJsonObject = jsonObject.getAsJsonObject(o.getClass().getName());
            for (Field field : Util.getFieldCollection(o)) {
                field.setAccessible(true);
                JsonElement fieldValue = oJsonObject.get(field.getName());
                if (fieldValue == null) {
                    JsonObject fieldJsonObject = jsonObject.getAsJsonObject(field.getType().getName());
                    field.set(o, gson.fromJson(fieldJsonObject.get("value"), field.getType()));
                } else {
                    field.set(o, gson.fromJson(oJsonObject.get(field.getName()), field.getType()));
                }
            }
        } else {
            JsonObject oJsonObject;

            for (Field field : Util.getFieldCollection(o)) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Default.class)) {
                    jsonObject = (JsonObject) new JsonParser().parse(new FileReader(field.getAnnotation(Default.class).value()));
                    oJsonObject = jsonObject.getAsJsonObject(o.getClass().getName());
                    if (oJsonObject.get(field.getName()) == null) {
                        JsonObject fieldJsonObject = jsonObject.getAsJsonObject(field.getType().getName());
                        field.set(o, gson.fromJson(fieldJsonObject.get("value"), field.getType()));
                    } else {
                        field.set(o, gson.fromJson(oJsonObject.get(field.getName()), field.getType()));
                    }
                }
            }
        }

    }

    public static void reset1(Object o, ApplicationContext ctx) {
        newDefault ann;
        Class<?> clazz = o.getClass();
        if (clazz.isAnnotationPresent(newDefault.class)) {//ЕСЛИ ПРОАНАТАТИРОВАН КЛАСС
            Field[] oFields = Util.getFieldCollection(o);
            ann = clazz.getAnnotation(newDefault.class);
            Object defObj = ctx.getBean(ann.beanName());
            for(Field field : oFields){
//                try{
                    field.setAccessible(true);
                    if(field.isAnnotationPresent(Default.class)){
                        ann = field.getAnnotation(newDefault.class);
                        Object obj = ctx.getBean(ann.beanName());
                        System.out.println(obj);
                        ReflectionUtils.setField(field, o, obj);
                    }else{
                        ReflectionUtils.setField(field, o, ReflectionUtils.getField(field, defObj));
                    }

            }
        } else {
            Field[] oFields = Util.getFieldCollection(o);
            for (int i = 0; i < oFields.length; i++) {
                Field oField = oFields[i];
                try {
                    oField.setAccessible(true);
                    if (oField.isAnnotationPresent(newDefault.class)) {
                        ann = oField.getAnnotation(newDefault.class);
                        Object obj = ctx.getBean(ann.beanName());
                        ReflectionUtils.setField(oField, o, obj);
                    }
                } catch (Exception ignored) {

                }

            }

        }


    }
}
