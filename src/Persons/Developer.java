package Persons;

import java.util.ArrayList;
import java.util.List;

public class Developer  extends Employee{

    private static List<Developer> devsList = new ArrayList<>();

    public Developer(String firstName, String lastName, String email, String phoneNumber, String pesel) {
        super(firstName, lastName, email, phoneNumber, pesel);
        devsList.add(this);
    }

    public static List<Developer> getDevsList() {
        return devsList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
