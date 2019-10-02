public class SuperHero extends Person {

    public SuperHero() {

    }

    public Person createPerson(String personType) {
        if (personType == null) {
            return null;
        }

        if (personType.equalsIgnoreCase("HERO")) {
            return new Person();
        }
        return null;
    }
}