package spring.beanlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
//        StudentDAO studentDAO = appContext.getBean("studentDAO", StudentDAO.class);
//        System.out.println(studentDAO);
//        studentDAO.selectAllRows();
//        studentDAO.deleteRow("x");
        Hello hello = appContext.getBean("hello", Hello.class);
        hello.sample();
        appContext.close();
    }
}
