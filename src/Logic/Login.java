package Logic;

import Persons.Employee;

public class Login {

    private static Employee employee;

    public Login(){

    }

    public static boolean login(String login, String password){
        if(employee.getEmployeesLoginsMap().containsKey(login) && employee.employeesLoginsMap.get(login) == password){
            return true;
        }
        return false;
    }
}
