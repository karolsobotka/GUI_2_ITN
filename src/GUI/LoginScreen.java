package GUI;

import Logic.Login;
import javax.swing.*;
import java.awt.*;


public class LoginScreen extends JFrame {

    JButton loginButton = new JButton("Login");
    JLabel loginLabel = new JLabel("Login:");
    JTextField loginTextField = new JTextField();
    JLabel passwordLabel = new JLabel("Password:");
    JTextField passwordTextField = new JTextField();
    JPanel framePanel = new JPanel();
    JPanel valuesPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public LoginScreen(){
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

        loginButton.addActionListener(e -> {
           if(Login.login(loginTextField.getText(), passwordTextField.getText())){
               SwingUtilities.invokeLater(() -> {
                   ManagementScreen ms = new ManagementScreen(Login.isManger(loginTextField.getText()));
                   ms.setVisible(true);
                   dispose();
               });

           }else{
                JOptionPane.showMessageDialog(this,"Password or login are incorrect.");
           }

        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginScreen ls = new LoginScreen();
        });
    }
}
