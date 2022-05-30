package GUI;

import javax.swing.*;
import java.awt.*;

public class ManagementScreen extends JFrame {
    JButton loginButton = new JButton("Login");
    JLabel loginLabel = new JLabel("Login:");
    JTextField loginTextField = new JTextField();
    JLabel passwordLabel = new JLabel("Password:");
    JTextField passwordTextField = new JTextField();
    JPanel framePanel = new JPanel();
    JPanel valuesPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    public ManagementScreen(){
        framePanel.setLayout(new GridLayout(2,1));
        valuesPanel.setLayout(new GridLayout(2,2));
        valuesPanel.add(loginLabel);
        valuesPanel.add(loginTextField);
        valuesPanel.add(passwordLabel);
        valuesPanel.add(passwordTextField);
        buttonPanel.add(loginButton);
        framePanel.add(valuesPanel);
        framePanel.add(buttonPanel);
        add(framePanel);
        setVisible(true);
        setPreferredSize(new Dimension(200, 200));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


}
