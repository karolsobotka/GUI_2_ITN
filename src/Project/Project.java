package Project;

import Persons.Developer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Project {

    private String projectName;
    private final static int maxDevelopersAmount = 2;
    private List<String> commentsList = new ArrayList<>();
    private static List<Project> projectList = new ArrayList<>();

    public Project(){

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public static void addComment(Project project, String comment){
        project.commentsList.add(comment);

    }
    public static void addDeveloperToProject(Project project, Developer developer){

    }
    public static void createNewProject(String name){

    }

    public static List<Project> getProjectList() {
       return projectList;
    }

    public static void setProjectList(List<Project> projectList) {
        Project.projectList = projectList;
    }

    public static void main(String[] args) {

        while(true){

        }
    }

    @Override
    public String toString() {
        return projectName;
    }
}
