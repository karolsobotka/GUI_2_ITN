package Logic;

import Persons.Employee;
import Persons.Manager;

public class Login {

    public static Employee getLoggedUser() {
        return loggedUser;
    }

    private static Employee loggedUser;
    public static boolean login(String login, String password){
        if(Employee.getEmployeesLoginsMap().containsKey(login) && Employee.getEmployeesLoginsMap().get(login).equals(password)){
            return true;
        }
        else
            return false;
    }

    public static Boolean isManger(String login) {
       Employee emp =  Employee.getEmployeeList().stream().filter(e  -> login.equals(e.getLogin())).findFirst().orElse(null);
       if(emp instanceof Manager){
           loggedUser = emp;
           return true;
       }
       else {
           loggedUser = emp;
           return false;
       }
    }
}
