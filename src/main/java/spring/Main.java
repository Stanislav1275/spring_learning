package spring;

import classes.*;
import classes.PostProcessors.HumanHandler;
import classes.Stonks.Stonk;
import classes.Stonks.StonkCastle;
import classes.Stonks.Stonker;
import classes.Streaming.Changer;
import lombok.SneakyThrows;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("spring");
//        s_8_2_1(ctx);
//        s_8_2_2(ctx);
//        s_8_2_3(ctx);
//        s_8_2_4(ctx);
        s_8_3_1(ctx);
    }

    public static void s_8_2_1(ApplicationContext ctx) {
        for (int i = 0; i < 10; i++) {
            System.out.println(ctx.getBean("random"));
        }
    }

    public static void s_8_2_2(ApplicationContext ctx) {
        System.out.println(ctx.getBean("bestFeedBack", Feedback.class));
    }

    public static void s_8_2_3(ApplicationContext ctx) {
        TrafficLight tr = ctx.getBean("trafficLight", TrafficLight.class);
        for (int i = 0; i < 10; i++) {
            if (i == 3) tr.off();
            if (i == 6) tr.on();
            tr.next();
        }
    }

    public static void s_8_2_4(ApplicationContext ctx) {
//        TrafficLight t = ctx.getBean("trafficLight", TrafficLight.class);
//        for(int i = 0; i < 8; i++){
//            t.next();
//            if(i == 3) t.off();
//            if(i == 5)t.on();
//        }
//        Stonk s1 = new Stonk("s1",200);
//        Stonk s2 = new Stonk("s2",400);
//        StonkCastle st = ctx.getBean("stonkCastle", StonkCastle.class);
//
//        st.updatePrice(s1, 300);

//        StonkCastle stonkCastle = new StonkCastle();
//        stonkCastle.registerStonk(s1);
//        stonkCastle.registerStonk(s2);
        Changer changer = ctx.getBean("changer", Changer.class);
        changer.doActs();


    }
    @SneakyThrows
    public static void s_8_3_1(ApplicationContext ctx) {
        Student st =  ctx.getBean("getGoodSt", Student.class);
        System.out.println(st);
//
//
//        Cat cat =  ctx.getBean("catDef", Cat.class);
//        Enhancer e = new Enhancer();
//        e.setSuperclass(Cat.class);
//        Cat finalCat = cat;
//        e.setCallback(new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return method.invoke(finalCat, args);
//            }
//        });
//        cat = (Cat) e.create(new Class[]{int.class}, new Object[]{5});
//        System.out.println(cat.getClass().getConstructors()[0].getName());
//        System.out.println(cat);
        Objenesis ob = new ObjenesisStd();
        Cat cat = ob.newInstance(Cat.class);
        System.out.println(cat);
//        System.out.println(st);
//        System.out.println(cat);
    }


}
