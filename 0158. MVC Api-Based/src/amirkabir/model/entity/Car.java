package amirkabir.model.entity;

import javax.persistence.*;

@Entity(name = "Car")
@Table(name = "CAR")
public class Car {

    @Id
    @SequenceGenerator(name = "carSeq", sequenceName = "CAR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "carSeq")
    @Column(name = "ID", columnDefinition = "NUMBER")
    private long id;
    @Column(name = "MODEL", columnDefinition = "VARCHAR2(20)")
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public Car() {
    }

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
}
