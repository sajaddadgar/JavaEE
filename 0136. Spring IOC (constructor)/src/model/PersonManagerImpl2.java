package model;

public class PersonManagerImpl2 implements PersonManager {

    // with constructor
    /*public PersonManagerImpl2(String name){
        this.name = name;
    }*/

    // with setter
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void a() {
        System.out.println("bbbbbbbbbb " + getName());
    }
}
