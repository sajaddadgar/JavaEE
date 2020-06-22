package model;

public class PersonManagerImpl implements PersonManager {

    public PersonManagerImpl(String str1, String str2){

        System.out.println("i'm PersonManagerImpl()" + str1 + " " + str2);

    }

    public void start(){

        System.out.println("start");
    }
    public void end(){

        System.out.println("start");
    }

    @Override
    public void a() {
        System.out.println("aaaaaa");
    }


}
