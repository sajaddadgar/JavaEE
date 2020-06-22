package amirkabir.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {

    private long id;
    private String name, family;
    /*@JsonIgnore*/
    private Car car;

    public Person() {
    }

    public Person(long id, String name, String family, Car car) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.car = car;
    }

    public Car getCar() {

        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

}
