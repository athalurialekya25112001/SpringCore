package spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {

    @Autowired
    @Qualifier(value = "humanHeart")
    private Heart heart;

    public void startPumping() {
        if (heart != null) {
            heart.pump();
            System.out.println("I am " + heart.getNameOfAnimal() + ". And I have " + heart.getNoOfHeart() + " hearts");

        } else {
            System.out.println("You are dead!!!");
        }
    }
}
