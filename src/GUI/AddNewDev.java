package GUI;

import Persons.Developer;
import Project.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewDev extends JFrame {
    static DefaultListModel<Developer> model = new DefaultListModel<>();

    static JList<Developer> jListDevs = new JList<>(model);
    JButton addDevButton = new JButton("Add dev to Project");

    public AddNewDev(){

        add(jListDevs);
        add(addDevButton);


        addDevButton.addActionListener(e -> {
            //Project.addDeveloperToProject( , model.getElementAt(jListDevs.getSelectedIndex() );

        });
        setLayout(new GridLayout());
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        setTitle("Adding Dev");
    }

    public static Developer getSelectedDev(){
        return model.getElementAt(jListDevs.getSelectedIndex());
    }

    public static void main(String[] args) {
        AddNewDev addDev = new AddNewDev();
    }
}
