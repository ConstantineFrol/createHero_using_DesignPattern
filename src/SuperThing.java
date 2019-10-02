public class SuperThing {

    public SuperThing() {

    }

    public Person createThing(String thingType) {
        if (thingType == null) {
            return null;
        }

        if (thingType.equalsIgnoreCase("VILLAIN")) {
            return new SuperVillain();
        } else {
            return new SuperHero();
        }
    }
}