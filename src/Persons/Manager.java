package Persons;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager extends Employee{

    private static List<Manager> managerList = new ArrayList<>();

    public Manager(String firstName, String lastName,
                   String email, String phoneNumber, String pesel){
        super(firstName, lastName,email, phoneNumber, pesel);

        managerList.add(this);
    }








}
