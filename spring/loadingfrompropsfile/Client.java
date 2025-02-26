package spring.loadingfrompropsfile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("beans.xml laoded");
        Student student = context.getBean("student", Student.class);
        System.out.println("Student Class object created");
        student.displayStudentInfo();
    }

}
