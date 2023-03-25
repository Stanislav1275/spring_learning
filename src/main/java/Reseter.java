import classes.Default;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonToken;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

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
    public static void reset1(Object o){
        Field[] fields = Arrays.stream(Util.getFieldCollection(o))
                .filter(field -> field.isAnnotationPresent(Default.class)).toArray(size->new Field[size]);


    }


}
