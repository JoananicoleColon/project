package colon2;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;

public class FIRST {

    private JFrame frame;
    private JButton btnNewButton;
    private JPasswordField passwordField;
    private JTextField txtUsername;  

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FIRST window = new FIRST();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FIRST() {
        initialize();
        createEvent();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(700, 150, 600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(105, 55, 100, 30);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(105, 109, 100, 30);
        frame.getContentPane().add(lblPassword);

        // Username field
        txtUsername = new JTextField("Type your username");
        txtUsername.setBounds(173, 55, 260, 30);
        frame.getContentPane().add(txtUsername);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setBounds(173, 109, 260, 30);
        frame.getContentPane().add(passwordField);

        // Button
        btnNewButton = new JButton("Log In");
        btnNewButton.setBounds(245, 164, 120, 30);
        frame.getContentPane().add(btnNewButton);

        txtUsername.setColumns(10);
    }

    private void createEvent() {
      btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (username.equals("joana") && password.equals("colon")) {
                    JOptionPane.showMessageDialog(frame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });
        txtUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtUsername.getText().equals("Type your username")) {
                    txtUsername.setText("");
                }
            }
        });
    }
}
