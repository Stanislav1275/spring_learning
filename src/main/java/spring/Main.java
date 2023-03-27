package spring;

import classes.*;
import classes.Stonks.Stonk;
import classes.Stonks.StonkCastle;
import classes.Stonks.Stonker;
import classes.Streaming.Changer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("spring");
//        s_8_2_1(ctx);
        s_8_2_2(ctx);
//        s_8_2_3(ctx);
//        s_8_2_4(ctx);
//        s_8_3_1(ctx);
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

    public static void s_8_3_1(ApplicationContext ctx) {
        Student st = ctx.getBean("getGoodSt", Student.class);
//        Stonker stonker = ctx.getBean("st1", Stonker.class);
//        System.out.println(st.getName() + " student's name");
//        System.out.println(stonker.name+ " stonker's name");


    }


}
