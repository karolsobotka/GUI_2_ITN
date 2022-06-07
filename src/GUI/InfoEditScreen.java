package GUI;

import Logic.Login;
import Persons.Employee;

import javax.swing.*;
import java.awt.*;

public class InfoEditScreen extends JFrame {

    private JLabel fnameLabel = new JLabel("First Name");
    private JTextField fnameField = new JTextField();
    private JTextField fnameFieldOLD = new JTextField();
    private JLabel lnameLabel = new JLabel("Last name");
    private JTextField lnameField = new JTextField();
    private JTextField lnameFieldOLD = new JTextField();
    private JLabel emailLabel = new JLabel("E-mail:");
    private JTextField emailField = new JTextField();
    private JTextField emailFieldOLD = new JTextField();

    private JLabel phoneNumber = new JLabel("Phone Number:");
    private JTextField phoneNumberField = new JTextField();
    private JTextField phoneNumberFieldOLD = new JTextField();
    private JLabel peselLabel = new JLabel("Pesel");
    private JTextField peselField = new JTextField();
    private JTextField peselFieldOLD = new JTextField();
    private JButton confirmButton = new JButton("CONFIRM");
    Employee loggedUser = Login.getLoggedUser();


    public InfoEditScreen() {
        setLayout(new GridLayout(6,3));
        add(fnameLabel);
        add(fnameFieldOLD);
        fnameFieldOLD.setText(Login.getLoggedUser().getFirstName());
        fnameFieldOLD.setEditable(false);
        add(fnameField);
        add(lnameLabel);
        add(lnameFieldOLD);
        lnameFieldOLD.setText(Login.getLoggedUser().getLastName());
        lnameFieldOLD.setEditable(false);
        add(lnameField);
        add(emailLabel);
        add(emailFieldOLD);
        emailFieldOLD.setText(Login.getLoggedUser().getEmail());
        emailFieldOLD.setEditable(false);
        add(emailField);
        add(phoneNumber);
        add(phoneNumberFieldOLD);
        phoneNumberFieldOLD.setText(Login.getLoggedUser().getPhoneNumber());
        phoneNumberFieldOLD.setEditable(false);
        add(phoneNumberField);
        add(peselLabel);
        add(peselFieldOLD);
        peselFieldOLD.setText(Login.getLoggedUser().getPesel());
        peselFieldOLD.setEditable(false);
        add(peselField);
        add(confirmButton);

        confirmButton.addActionListener(e -> {
          loggedUser.setFirstName(fnameField.getText());
          loggedUser.setLastName(lnameField.getText());
          loggedUser.setEmail(emailField.getText());
          loggedUser.setPesel(peselField.getText());
          loggedUser.setPhoneNumber(phoneNumberField.getText());

          fnameFieldOLD.setText(fnameField.getText());
          lnameFieldOLD.setText(lnameFieldOLD.getText());
          emailFieldOLD.setText(emailField.getText());
          peselFieldOLD.setText(peselField.getText());
          phoneNumberFieldOLD.setText(phoneNumberField.getText());
        });
        setVisible(true);
        setPreferredSize(new Dimension(400,400));
        pack();
        setLocationRelativeTo(null);
        setTitle("Edit Personal Information");

    }

    public static void main(String[] args) {
        InfoEditScreen is = new InfoEditScreen();
    }
}
