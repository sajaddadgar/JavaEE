package model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Person")
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME", columnDefinition = "VARCHAR2(20)")
    private String name;
    // lazy nazaria, chon vaghti select zad ru person connection mibande vali
    // mishe be hibernate goft ke ta payan threadconnection ro nabande
    // eager bezar, chon ye select zad ru person ye select ham mizane be document
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK")
    private List<Document> document;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
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

    public List<Document> getDocument() {
        return document;
    }

    public void setDocument(List<Document> document) {
        this.document = document;
    }
}
