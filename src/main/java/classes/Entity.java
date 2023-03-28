package classes;


import Annotations.StringsVariants;
import Annotations.ToString;

import java.lang.reflect.Field;

public interface  Entity {
//    @Override
//    public String toString() {
//        StringBuilder res = new StringBuilder();
//        Class<?> currentClazz = this.getClass();
//        Field[] fields;
//        res.append(this.getClass().getSimpleName()).append("{");
//        while (currentClazz != Entity.class) {
//            fields = currentClazz.getDeclaredFields();
//            ToString classAnnotation = currentClazz.getAnnotation(ToString.class);
//            if (!(classAnnotation != null && classAnnotation.value() == StringsVariants.NO)) {
//                for (Field field : fields) {
//                    ToString fieldAnnotation = field.getAnnotation(ToString.class);
//                    field.setAccessible(true);
//                    if ((!(fieldAnnotation != null && fieldAnnotation.value() == StringsVariants.NO))) {//если поля неаанотировано или аннотиовано не с no
//                        try {
//                            res
//                                    .append(field.getName())
//                                    .append(" = ")
//                                    .append(field.get(this) + " ");
//                        } catch (IllegalAccessException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//            currentClazz = currentClazz.getSuperclass();
//        }
//        return res.append("}").toString();//если ToString value == NO, возвращаем toString родителя
//    }
}
