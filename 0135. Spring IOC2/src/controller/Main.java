package controller;

import common.IOC;
import model.PersonManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        while (true){

            Thread.sleep(5000);
            PersonManager personManager = (PersonManager) IOC.getBean("x");
            personManager.a();
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("y")){
                IOC.intializine();
            }
        }
    }
}
