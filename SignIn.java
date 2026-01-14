package colon2;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn {

    private JFrame frame;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JTextArea textArea;

    private JRadioButton rdbMale;
    private JRadioButton rdbFemale;

    private JRadioButton rdbFree;
    private JRadioButton rdbPremium;

    private JComboBox<String> comboAge;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SignIn window = new SignIn();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SignIn() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Sign In");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(260, 20, 100, 30);
        frame.getContentPane().add(lblTitle);

        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(70, 70, 100, 20);
        frame.getContentPane().add(lblFirstName);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(350, 70, 100, 20);
        frame.getContentPane().add(lblLastName);

        tfFirstName = new JTextField();
        tfFirstName.setBounds(70, 95, 180, 25);
        frame.getContentPane().add(tfFirstName);

        tfLastName = new JTextField();
        tfLastName.setBounds(350, 95, 180, 25);
        frame.getContentPane().add(tfLastName);

        JLabel lblUsername = new JLabel("User Name");
        lblUsername.setBounds(70, 140, 100, 20);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Pass");
        lblPassword.setBounds(350, 140, 100, 20);
        frame.getContentPane().add(lblPassword);

        tfUsername = new JTextField();
        tfUsername.setBounds(70, 165, 180, 25);
        frame.getContentPane().add(tfUsername);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(350, 165, 180, 25);
        frame.getContentPane().add(pfPassword);

        JLabel lblSex = new JLabel("Sex");
        lblSex.setBounds(70, 210, 100, 20);
        frame.getContentPane().add(lblSex);

        rdbMale = new JRadioButton("Male");
        rdbMale.setBounds(70, 235, 60, 20);
        frame.getContentPane().add(rdbMale);

        rdbFemale = new JRadioButton("Female");
        rdbFemale.setBounds(140, 235, 80, 20);
        frame.getContentPane().add(rdbFemale);

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(rdbMale);
        sexGroup.add(rdbFemale);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(350, 210, 100, 20);
        frame.getContentPane().add(lblAge);

        comboAge = new JComboBox<>(new String[]{
                "10","11","12","13","14","15","16","17","18","19","20"
        });
        comboAge.setBounds(350, 235, 180, 22);
        frame.getContentPane().add(comboAge);

        JLabel lblSub = new JLabel("Subscription");
        lblSub.setBounds(70, 265, 100, 20);
        frame.getContentPane().add(lblSub);

        rdbFree = new JRadioButton("Free");
        rdbFree.setBounds(70, 290, 60, 20);
        frame.getContentPane().add(rdbFree);

        rdbPremium = new JRadioButton("Premium");
        rdbPremium.setBounds(140, 290, 100, 20);
        frame.getContentPane().add(rdbPremium);

        ButtonGroup subGroup = new ButtonGroup();
        subGroup.add(rdbFree);
        subGroup.add(rdbPremium);

        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setBounds(350, 290, 100, 25);
        frame.getContentPane().add(btnSignIn);

        textArea = new JTextArea();
        textArea.setBounds(70, 330, 460, 120);
        frame.getContentPane().add(textArea);

        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(
                        "First Name: " + tfFirstName.getText() +
                        "\nLast Name: " + tfLastName.getText() +
                        "\nUsername: " + tfUsername.getText() +
                        "\nSex: " + (rdbMale.isSelected() ? "Male" : "Female") +
                        "\nSubscription: " + (rdbFree.isSelected() ? "Free" : "Premium") +
                        "\nAge: " + comboAge.getSelectedItem()
                );
            }
        });
    }
}
