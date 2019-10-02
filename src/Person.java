import java.io.Serializable;

public class Person implements Serializable {
    String name;
    String type;

    public Person() {
    }

    public Person(String name, String type) {
        setName(name);
        setType(type);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "\nPerson:" +
                "\nName:\t" + getName() +
                "\nType:\t" + getType();
    }
}