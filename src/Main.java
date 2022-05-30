import Persons.Employee;
import Persons.Manager;

public class Main {

    public static void main(String[] args) {
        Manager m = new Manager("Jan", "Kowalski", "j.kowalski@gmail.com",
                "507112273", "99020906395");

        System.out.println(m);

        System.out.println(m.getEmployeesLoginsMap().get(m.getLogin()));

        while(true){

        }
    }
}
