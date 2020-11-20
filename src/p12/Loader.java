package p12;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static void main(String[] args) {
        System.out.println(parseFile());

        Gson json = new Gson();

        Person person = json.fromJson(parseFile(), Person.class);

        System.out.println(person.firstName + " " + person.lastName + " " + person.age + " " + person.isMan);

        person.phoneNumbers.forEach(System.out::println);

        System.out.println(person.adress.city + " " + person.adress.street);
        person.phonesNumbers.forEach(phone -> System.out.println(phone.number + " " + phone.type));


        Person person1 = new Person();
        person1.firstName = "Петя";
        person1.lastName = "Васильев";
        person1.isMan = true;
        person1.age = 35;
        person1.phoneNumbers.add("78477485948");

        Phone phone = new Phone();
        phone.type = "home";
        phone.number = "78477485948";
        person1.phonesNumbers.add(phone);

        person1.adress.street = "Red Squear";
        person1.adress.city = "Moscow";

        String jsonS = json.toJson(person1);

        System.out.println(jsonS);

    }

    public static String parseFile() {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> files = Files.readAllLines(Paths.get("data/P12.json"));

            files.forEach(file -> builder.append(file).append("\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }
}

class Person
{
    public String firstName;
    public String lastName;
    public int age;
    public boolean isMan;
    public List<String> phoneNumbers = new ArrayList<>();
    public Adress adress = new Adress();
    public List<Phone> phonesNumbers = new ArrayList<>();
}

class Adress {
    public String city;
    public String street;
}

class Phone {
    public String type;
    public String number;
}