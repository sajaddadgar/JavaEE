package model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Car")
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "MODEL", columnDefinition = "VARCHAR2(20)")
    private String model;
    @ManyToMany(mappedBy = "carList", cascade = CascadeType.PERSIST)
    private List<Person> personList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
