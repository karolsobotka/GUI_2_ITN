import GUI.LoginScreen;
import Persons.Developer;
import Persons.Employee;
import Persons.Manager;
import Project.Project;
import Project.Comment;

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

        Project p = new Project();
        p.setProjectName("hello");


      LoginScreen ls = new LoginScreen();

        Project p1 = new Project();
        p1.setProjectName("hello1");

        Project p2= new Project();
        p2.setProjectName("hello2");
        Project p3 = new Project();
        Project p4 = new Project();
        Project.getProjectList().add(p1);
        Project.getProjectList().add(p2);
        Project.getProjectList().add(p3);
        Project.getProjectList().add(p4);

        Comment c = new Comment("Hejka","Nowak");
        System.out.println(c);



    }
}
