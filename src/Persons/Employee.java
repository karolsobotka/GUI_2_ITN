package Persons;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String pesel;
    private String login;
    private String password;
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    public static Map<String, String> employeesLoginsMap = new HashMap<>();

    public Employee(String firstName, String lastName, String email, String phoneNumber, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pesel = pesel;
        this.login = generateLogin();
        this.password = generatePassword(8);
        employeesLoginsMap.put(login, password);
        employeeList.add(this);

    }


    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public String getLogin() {
        return login;
    }
    private String generateLogin(){
        String login = firstName.substring(0,3)+lastName.substring(0,4)+pesel.substring(8,11);
        return login;
    }
    private  String generatePassword(int length) {
            String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
            String specialCharacters = "!@#$";
            String numbers = "1234567890";
            String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
            Random random = new Random();
            char[] password = new char[length];

            password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
            password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
            password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
            password[3] = numbers.charAt(random.nextInt(numbers.length()));

            for(int i = 4; i< length ; i++) {
                password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
            }

            String finalPassword = "";
            for (char c :password) {
                finalPassword += c;
            }
            return finalPassword;
        }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public static Map<String, String> getEmployeesLoginsMap() {
        return employeesLoginsMap;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
