package colon2;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login2 {

    private JFrame frame;
    private JTextField userField;
    private JPasswordField passField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login2 window = new Login2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Login");
        frame.setBounds(100, 100, 505, 305);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(74, 64, 100, 25);
        frame.getContentPane().add(lblUser);

        userField = new JTextField();
        userField.setBounds(184, 64, 200, 25);
        frame.getContentPane().add(userField);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(74, 100, 100, 25);
        frame.getContentPane().add(lblPass);

        passField = new JPasswordField();
        passField.setBounds(184, 100, 200, 25);
        frame.getContentPane().add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(222, 163, 100, 30);
        frame.getContentPane().add(loginBtn);

        // Button action
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = String.valueOf(passField.getPassword());

                if (username.equals("joana") && password.equals("colon")) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });
    }
}
