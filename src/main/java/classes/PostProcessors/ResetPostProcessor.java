package classes.PostProcessors;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import util.Reseter;
@Component
@ComponentScan("classes")
public class ResetPostProcessor implements BeanPostProcessor {
    @Autowired
    ApplicationContext ctx;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Reseter.reset1(bean,ctx);
//        System.out.println(ctx == null);
        return bean;
    }
}
