package common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOC {

    private static ApplicationContext iocContainer = new ClassPathXmlApplicationContext("spring.xml");

    public static Object getBean(String beanID){

        return iocContainer.getBean(beanID);

    }

    public static void intializine(){

        iocContainer = new ClassPathXmlApplicationContext("spring.xml");

    }
}
