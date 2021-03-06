package GUI;

import Logic.Login;
import Persons.Developer;
import Project.Project;
import Project.ProjectState;
import Project.Comment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static Project.ProjectState.ACTIVE;
import static Project.ProjectState.FINISHED;

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
    JList <Project> listaProjektow = new JList(model);
    static Project selectedProject;
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
    JButton editInfoButton = new JButton("Edit Info");

    public static Project getSelectedProject() {
        return selectedProject;
    }

    public ManagementScreen(Boolean isManager){

        getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK));
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.BLACK);
        mainContainer.add(topMenuPanel,BorderLayout.NORTH);
        topMenuPanel.setBackground(Color.YELLOW);
        scrollPaneProjektow.add(listaProjektow);
        listaProjektow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        mainContainer.add(projectInfoPanel, BorderLayout.CENTER);
        mainContainer.add(commentPanel,BorderLayout.SOUTH);
        mainContainer.add(panelListyProjektow, BorderLayout.WEST);
        panelListyProjektow.setLayout(new BorderLayout());
        panelListyProjektow.add(listaProjektow, BorderLayout.NORTH);

        panelListyProjektow.add(filterComboBox, BorderLayout.SOUTH);
        projectMenu.add(addProject);

        commentListArea.setEditable(false);

        commentPanel.setBackground(Color.ORANGE);
        commentArea.setPreferredSize(new Dimension(800,100));
        commentPanel.add(commentArea);
        commentPanel.add(commentButton);
        projectInfoPanel.setLayout(new GridLayout(6,2));
        projectInfoPanel.add(projectNameLabel);
        projectInfoPanel.add(projectName);
        projectName.setEditable(false);
        projectInfoPanel.add(developersCountLabel);
        developersCountField.setEditable(false);
        projectInfoPanel.add(developersCountField);
        projectInfoPanel.add(descriptionLabel);
        projectDescriptionField.setEditable(false);
        projectInfoPanel.add(projectDescriptionField);
        projectInfoPanel.add(statusLabel);
        projectInfoPanel.add(statusField);
        statusField.setEditable(false);
        projectInfoPanel.add(commentsLabel);
        projectInfoPanel.add(commentListArea);
        projectInfoPanel.add(editInfoButton);
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
                for (Developer d: p.getDevArray()) {
                    if(d == Login.getLoggedUser()){
                        model.addElement(p);
                    }
                }

            }

        }
        commentButton.addActionListener(e -> {
            new Thread(() -> {
                Project.addComment(model.getElementAt(listaProjektow.getSelectedIndex()), new Comment(commentArea.getText(), Login.getLoggedUser().getLogin()));
                commentListArea.setText("");
                String str = "";
                for (Comment c :  model.getElementAt(listaProjektow.getSelectedIndex()).getCommentsList()) {
                    str += "\n"+c.toString()+"\n";
                    commentListArea.setText(str);
                }
                commentListArea.setText(model.getElementAt(listaProjektow.getSelectedIndex()).getCommentsList().toString());
                commentArea.setText("");
            }).start();
        });


        listaProjektow.addListSelectionListener(e -> {
            new Thread(() -> {
                selectedProject = model.getElementAt(listaProjektow.getSelectedIndex());
                Project p = model.getElementAt(listaProjektow.getSelectedIndex());
                projectName.setText(p.getProjectName());
                statusField.setText(p.getProjectState().toString());
                commentListArea.setText(model.getElementAt(listaProjektow.getSelectedIndex()).getCommentsList().toString());
                developersCountField.setText(model.getElementAt(listaProjektow.getSelectedIndex()).getCommentsList().toString());
            }).start();

        });

        addProject.addActionListener(e -> {
            NewProjectInfo ns = new NewProjectInfo();
        });


        editInfoButton.addActionListener(e -> {
                InfoEditScreen infoEdit = new InfoEditScreen();
        });

        addEmployee.addActionListener(e -> {
            AddNewDev ad = new AddNewDev();
        });

        executeJob.addActionListener(e -> {
           if(startJob.isSelected()){
               selectedProject.setProjectState(ACTIVE);
               statusField.setText(model.getElementAt(listaProjektow.getSelectedIndex()).getProjectState().toString());

           }
           else if(endJob.isSelected()){
               selectedProject.setProjectState(FINISHED);
               statusField.setText(model.getElementAt(listaProjektow.getSelectedIndex()).getProjectState().toString());

           }
           else
               JOptionPane.showMessageDialog(this,"Choose what to do with project!");

        });

        Action logout = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                LoginScreen login = new LoginScreen();
            }
        };





        InactivityListener listener = new InactivityListener(this, logout, 1);
        listener.start();


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
