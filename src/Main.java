import GUI.LoginScreen;
import Persons.Developer;
import Persons.Employee;
import Persons.Manager;
import Project.Project;

public class Main {

    public static void main(String[] args) {
        Manager m = new Manager("Jan", "Kowalski", "j.kowalski@gmail.com",
                "507112273", "99020906395");
        Developer d = new Developer("Adam", "Developerski","d.loper@o2.pl",
                "5046242132","99842456621");

        System.out.println(m);
        System.out.println(d);

        System.out.println(Employee.getEmployeesLoginsMap().get(m.getLogin()));
        System.out.println(Employee.getEmployeesLoginsMap().get(d.getLogin()));

      LoginScreen ls = new LoginScreen();

        Project p1 = new Project();
        Project p2= new Project();
        Project p3 = new Project();
        Project p4 = new Project();
        Project.getProjectList().add(p1);
        Project.getProjectList().add(p2);
        Project.getProjectList().add(p3);
        Project.getProjectList().add(p4);



    }
}
