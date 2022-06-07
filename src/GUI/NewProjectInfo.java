package GUI;

import javax.swing.*;
import java.awt.*;
import Project.Project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProjectInfo extends JFrame {

    private JLabel projectnameLabel = new JLabel("Project name:");
    private JTextField projectnameTextField = new JTextField();
    private JButton createProjectButton = new JButton("Create project");

    public NewProjectInfo(){

        add(projectnameLabel);
        add(projectnameTextField);
        add(createProjectButton);

        createProjectButton.addActionListener(e -> {
            if(projectnameTextField.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Specify name of the Project");
            }else {
                Project p = new Project(projectnameTextField.getText());
                JOptionPane.showMessageDialog(this,"Project created succesfully!");
                projectnameTextField.setText("");
            }

        });

        setLayout(new GridLayout(2,2));
        setTitle("New Project");
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        NewProjectInfo ns=  new NewProjectInfo();
    }
}
