package GUI;

import Project.Project;

import javax.swing.*;
import java.awt.*;

public class ManagementScreen extends JFrame {
    JPanel framePanel = new JPanel();
    JPanel projectInfoPanel = new JPanel();
    JPanel commentPanel = new JPanel();

    JMenuBar menuBar = new JMenuBar();
    JMenu employeeMenu = new JMenu("Employee");
    JMenuItem addEmployee = new JMenuItem("Add Employee");
    JMenuItem removeEmployee = new JMenuItem("Remove Employee");

    JScrollPane panelListyProjektow= new JScrollPane();
    JList listaProjektow = new JList();
    JComboBox filterComboBox = new JComboBox();

    JRadioButton startJob = new JRadioButton("start job on Project");
    JRadioButton endJob = new JRadioButton("End job on project");
    JButton executeJob = new JButton("Proceed");
    DefaultListModel<Project> model = new DefaultListModel<>();



    public ManagementScreen(Boolean isManager){
        framePanel.setLayout(new FlowLayout());
        framePanel.add(executeJob);
        framePanel.add(startJob);
        framePanel.add(endJob);

        listaProjektow.setModel(model);
        model.addAll(Project.getProjectList());
        panelListyProjektow.add(listaProjektow);
        framePanel.add(panelListyProjektow);



        if(isManager){

        }


        if(!isManager) {


        }

        add(framePanel);
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
