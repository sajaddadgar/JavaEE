package common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOC {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    public static Object getBean(String beanId){
        return applicationContext.getBean(beanId);
    }

    public static void intialize(){
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

}
