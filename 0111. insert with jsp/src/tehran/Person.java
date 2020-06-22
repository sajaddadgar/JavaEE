package tehran;

public class Person {

    private long id;
    private String name;
    private String family;

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Person(long id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
