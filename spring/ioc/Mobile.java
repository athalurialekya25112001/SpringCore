package spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    public static void main(String[] args){
        // Beauty of Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("config loaded");


        // using objects
        Airtel air = (Airtel) context.getBean("airtel");
        air.calling();
        air.data();

        Vodaphone voda = context.getBean("vodaphone", Vodaphone.class);
        voda.calling();
        voda.data();

        // through interface
        // If a new sim Jio comes into market then also it works with configurable xml file
        // with the below code we need not touch source code

        Sim sim = context.getBean("sim", Sim.class);
        sim.calling();
        sim.data();
    }
}
