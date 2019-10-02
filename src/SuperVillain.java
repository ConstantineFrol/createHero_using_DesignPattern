public class SuperVillain extends Person {

    public SuperVillain() {

    }

    public Person createPerson(String personType) {
        if (personType == null) {
            return null;
        }

        if (personType.equalsIgnoreCase("VILLAIN")) {
            return new Person();
        }
        return null;
    }
}