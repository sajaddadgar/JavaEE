package controller;

import common.IOC;
import model.PersonManager;
import model.PersonManagerFactory;

public class Main {

    public static void main(String[] args) {


        PersonManager personManager1 = (PersonManager) IOC.getBean("x");
        PersonManager personManager2 = (PersonManager) IOC.getBean("x");
        PersonManager personManager3 = (PersonManager) IOC.getBean("x");

        personManager1.a();

    }

}
