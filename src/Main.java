import java.io.*;
import java.util.Random;

public class Main {
    // Location of the file
    private static final String filepath = "C:" + File.separator + "battle-zone-1";

    private enum badGuysNames {
        MAGNETO, JOKER, KINGPIN, LOKI, MYSTIQUE, VENOM, SHREDDER;

        public static badGuysNames getRandomNames() {
            Random rand = new Random();
            return values()[rand.nextInt(values().length)];
        }
    }

    public static void main(String[] args) {

        // I create Objects
        for (int i = 0; i <= (int) Math.random() * 10 + 3; i++) {

            SuperThing evilPerson = new SuperThing();
            Person thing = evilPerson.createThing("villain");
            thing.setName(badGuysNames.getRandomNames().toString());
            System.out.println(thing.toString());
            checkFileStatus(filepath, thing);
        }
    }

    // Save object into file
    public static void writeObjectToFile(Person serObj, String fileName) {

        try {
            FileOutputStream fileOut = new FileOutputStream(
                    new File(
                            filepath + File.separator + fileName + ".ser"
                    )
            );
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            fileOut.close();
            System.out.println(
                    "The Object  was successfully written to a file\n" +
                            "File name:\t" + fileName + ".ser"
            );

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    //Check Object file exist or not
    public static void checkFileStatus(String filepath, Person obj) {

        System.out.println("Path:\t" + filepath + "\n");
        String fileName = obj.getName();
        File tempFile = new File(filepath + "\\" + fileName + ".ser");

        File theDir = new File(filepath);

// if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (NoSuchFieldError e) {
                System.out.println(e.getMessage());
            }
            if (result) {
                System.out.println(theDir.getName() + " created");
            }
        } else {
            System.out.println("Directory:\t" + theDir.getName() + " already exists !!!");
        }
        writeObjectToFile(obj, fileName);
    }
}