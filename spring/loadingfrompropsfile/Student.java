package spring.loadingfrompropsfile;

import org.springframework.beans.factory.annotation.Value;

public class Student {

    @Value("${student.name}")
    private String name;

    @Value("${student.interestedCourse}")
    private String interestedCourse;

    @Value("${student.hobby}")
    private String hobby;


    public void displayStudentInfo() {
        System.out.println("Student Name - " + name);
        System.out.println("Student interestedCourse - " + interestedCourse);
        System.out.println("Student hobby - " + hobby);

    }
}
