package controller;

import common.IOC;
import model.PersonManager;

public class Main {

    public static void main(String[] args) {

        // nullPointerException
        /*PersonManager personManager = new PersonManager();
        personManager.a();*/
        PersonManager personManager = (PersonManager) IOC.getBean("x");
        personManager.a();

    }

}
