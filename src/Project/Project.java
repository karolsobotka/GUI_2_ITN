package Project;

import Persons.Developer;

import java.util.ArrayList;
import java.util.List;

import static Project.ProjectState.PLANNED;

public class Project {

    private String projectName;
    private ProjectState projectState;
    private final static int maxDevelopersAmount = 2;
    public Project(){
        devArray = new Developer[maxDevelopersAmount];
        this.projectState = PLANNED;
    }
    public Project(String projectName){
        this.projectName = projectName;
        devArray = new Developer[maxDevelopersAmount];
        this.projectState = PLANNED;
    }

    private List<Comment> commentsList = new ArrayList<>();
    private static List<Project> projectList = new ArrayList<>();

    public Developer[] getDevArray() {
        return devArray;
    }
    public List<Comment> getCommentsList() {
        return commentsList;
    }
    private Developer [] devArray;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public static void addComment(Project project, Comment comment){
        project.commentsList.add(comment);

    }

    public static void addDeveloperToProject(Project project, Developer developer){
        System.out.println(project.getDevArray());
        Developer [] projectsArrayofDevs =  project.getDevArray();
        if(projectsArrayofDevs.length == 0){
           projectsArrayofDevs[0] = developer;
            System.out.println("dodano deva 1");
        }
        if(projectsArrayofDevs.length == 1){
            projectsArrayofDevs[1] = developer;
            System.out.println("dodano deva 2");

        }
        else
            System.out.println("too much devs on project");
    }
    public ProjectState getProjectState() {
        return projectState;
    }

    public void setProjectState(ProjectState projectState) {
        this.projectState = projectState;
    }

    public static List<Project> getProjectList() {
       return projectList;
    }

    public static void setProjectList(List<Project> projectList) {
        Project.projectList = projectList;
    }

    @Override
    public String toString() {
        return projectName;
    }
}
