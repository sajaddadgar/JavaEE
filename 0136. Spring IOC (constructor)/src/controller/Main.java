package controller;

import common.IOC;
import model.PersonManager;

public class Main {

    public static void main(String[] args) {

        // constructor faghat ye bar ejra mishavad (default spring singleton ast)
        // dar surati ke scope spring.xml prototype bashad constructor 3 bar ejra mishavad
        /*PersonManager personManager1 = (PersonManager) IOC.getBean("x");
        PersonManager personManager2 = (PersonManager) IOC.getBean("x");
        PersonManager personManager3 = (PersonManager) IOC.getBean("x");*/

        PersonManager personManager1 = (PersonManager) IOC.getBean("y");

        personManager1.a();

    }

}
