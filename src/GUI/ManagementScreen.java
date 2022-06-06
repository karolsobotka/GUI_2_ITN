package GUI;

import Project.Project;
import Project.ProjectState;
import Project.Comment;

import javax.swing.*;
import java.awt.*;


public class ManagementScreen extends JFrame {
    Container mainContainer = getContentPane();
    JPanel topMenuPanel = new JPanel();
    JPanel projectInfoPanel = new JPanel();
    JPanel commentPanel = new JPanel();
    JTextArea commentArea = new JTextArea();
    JButton commentButton = new JButton("Add Comment");

    JMenuBar menuBar = new JMenuBar();
    JMenu employeeMenu = new JMenu("Employee");
    JMenu projectMenu = new JMenu("Project");
    JMenuItem addProject = new JMenuItem("Add project");
    JMenuItem addEmployee = new JMenuItem("Add Employee");
    JMenuItem removeEmployee = new JMenuItem("Remove Employee");

    JPanel panelListyProjektow = new JPanel();
    JScrollPane scrollPaneProjektow = new JScrollPane();
    JPanel decisionPanel = new JPanel();
    DefaultListModel<Project> model = new DefaultListModel<>();
    JList listaProjektow = new JList(model);
    JComboBox filterComboBox = new JComboBox(ProjectState.values());
    JLabel whatToDo = new JLabel("What you want to do with project?");
    JRadioButton startJob = new JRadioButton("Start job on the project");
    JRadioButton endJob = new JRadioButton("End job on the project");
    JButton executeJob = new JButton("Execute");
    JLabel projectNameLabel = new JLabel("Project Name:");
    JTextField projectName = new JTextField();
    JLabel developersCountLabel = new JLabel("Developers Count:");

    JTextField developersCountField = new JTextField();

    JLabel descriptionLabel = new JLabel("Project Description:");
    JTextField projectDescriptionField = new JTextField();
    JLabel statusLabel = new JLabel("Status:");
    JTextField statusField = new JTextField();

    JLabel commentsLabel = new JLabel("Comments:");
    JTextArea commentListArea = new JTextArea();

    public ManagementScreen(Boolean isManager){


        getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK));
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.BLACK);
        mainContainer.add(topMenuPanel,BorderLayout.NORTH);
        topMenuPanel.setBackground(Color.YELLOW);
        scrollPaneProjektow.add(listaProjektow);
        mainContainer.add(projectInfoPanel, BorderLayout.CENTER);
        mainContainer.add(commentPanel,BorderLayout.SOUTH);
        mainContainer.add(panelListyProjektow, BorderLayout.WEST);
        panelListyProjektow.setLayout(new BorderLayout());
        panelListyProjektow.add(listaProjektow, BorderLayout.NORTH);
        panelListyProjektow.add(filterComboBox, BorderLayout.SOUTH);
        projectMenu.add(addProject);


        commentPanel.setBackground(Color.ORANGE);
        commentArea.setPreferredSize(new Dimension(800,100));
        commentPanel.add(commentArea);
        commentPanel.add(commentButton);
        projectInfoPanel.setLayout(new GridLayout(6,2));
        projectInfoPanel.add(projectNameLabel);
        projectInfoPanel.add(projectName);
        projectName.setEditable(false);
        projectInfoPanel.add(developersCountLabel);
        projectInfoPanel.add(developersCountField);
        projectInfoPanel.add(descriptionLabel);
        projectInfoPanel.add(projectDescriptionField);
        projectInfoPanel.add(statusLabel);
        projectInfoPanel.add(statusField);
        projectInfoPanel.add(commentsLabel);
        projectInfoPanel.add(commentListArea);
        decisionPanel.setLayout(new GridLayout(3,0));
        decisionPanel.add(whatToDo);
        decisionPanel.add(startJob);
        decisionPanel.add(endJob);
        decisionPanel.add(executeJob);



        if(isManager){
            menuBar.add(employeeMenu);
            employeeMenu.add(addEmployee);
            employeeMenu.add(removeEmployee);
            menuBar.add(projectMenu);

            topMenuPanel.add(menuBar);

            for (Project p : Project.getProjectList()) {
                model.addElement(p);
            }
        }


        if(!isManager) {
            projectInfoPanel.add(decisionPanel);
            for (Project p : Project.getProjectList()) {

                model.addElement(p);
            }

        }
        commentButton.addActionListener(e ->{
                 Comment comment = new Comment( commentArea.getText(), "Autor");

                }
        );




        setVisible(true);
        setPreferredSize(new Dimension(1024, 720));
        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Management Screen");

    }





    public static void main(String[] args) {
        ManagementScreen ms = new ManagementScreen(true);
    }


}
