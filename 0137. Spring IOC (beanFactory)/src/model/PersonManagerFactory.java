package model;

public class PersonManagerFactory {

    private static PersonManagerImpl personManager = new PersonManagerImpl();

    public Object getP(){

        System.out.println("i'm getP()");
        return personManager;
    }

}
