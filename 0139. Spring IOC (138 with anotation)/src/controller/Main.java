package controller;

import common.IOC;
import model.PersonManager;

public class Main {
    public static void main(String[] args) {


        PersonManager personManager = (PersonManager) IOC.getBean("personManager");

        personManager.a();

    }
}
