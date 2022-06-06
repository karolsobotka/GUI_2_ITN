package GUI;

import Project.Project;

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
    JMenuItem addEmployee = new JMenuItem("Add Employee");
    JMenuItem removeEmployee = new JMenuItem("Remove Employee");

    JPanel panelListyProjektow = new JPanel();
    JScrollPane scrollPaneProjektow = new JScrollPane();
    DefaultListModel<Project> model = new DefaultListModel<>();
    JList listaProjektow = new JList(model);
    String [] projectStates = {"Active", "Planned", "Closed"};

    JComboBox filterComboBox = new JComboBox(projectStates);

    JRadioButton startJob = new JRadioButton("start job on Project");
    JRadioButton endJob = new JRadioButton("End job on project");
    JButton executeJob = new JButton("Proceed");


    public ManagementScreen(Boolean isManager){
        getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.GREEN));
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.GREEN);
        mainContainer.add(topMenuPanel,BorderLayout.NORTH);
        topMenuPanel.setBackground(Color.YELLOW);

        listaProjektow.setPreferredSize(new Dimension(100,500));
        scrollPaneProjektow.add(listaProjektow);
        mainContainer.add(projectInfoPanel, BorderLayout.CENTER);
        projectInfoPanel.setBackground(Color.RED);
        mainContainer.add(commentPanel,BorderLayout.SOUTH);
        mainContainer.add(panelListyProjektow, BorderLayout.WEST);
        panelListyProjektow.setLayout(new BorderLayout());
        panelListyProjektow.add(listaProjektow, BorderLayout.NORTH);
        panelListyProjektow.add(filterComboBox, BorderLayout.SOUTH);


        commentPanel.setBackground(Color.ORANGE);
        commentArea.setPreferredSize(new Dimension(800,100));
        commentPanel.add(commentArea);
        commentPanel.add(commentButton);


        if(isManager){
            menuBar.add(employeeMenu);
            employeeMenu.add(addEmployee);
            employeeMenu.add(removeEmployee);

            topMenuPanel.add(menuBar);
        }


        if(!isManager) {


        }




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
