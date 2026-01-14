package colon2;

import javax.swing.*;

public class BMICalculator {

    private JFrame frame;
    private JTextField tfName, tfAge, tfHeight, tfWeight;
    private JLabel lblBMI, lblCategory;

    public BMICalculator() {
        initialize();
    }

    public void show() {
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("BMI Calculator");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // ===== INPUT =====
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30, 40, 120, 25);
        frame.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(150, 40, 200, 25);
        frame.add(tfName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(30, 80, 120, 25);
        frame.add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(150, 80, 200, 25);
        frame.add(tfAge);

        JLabel lblHeight = new JLabel("Height (meters):");
        lblHeight.setBounds(30, 120, 120, 25);
        frame.add(lblHeight);

        tfHeight = new JTextField();
        tfHeight.setBounds(150, 120, 200, 25);
        frame.add(tfHeight);

        JLabel lblWeight = new JLabel("Weight (kg):");
        lblWeight.setBounds(30, 160, 120, 25);
        frame.add(lblWeight);

        tfWeight = new JTextField();
        tfWeight.setBounds(150, 160, 200, 25);
        frame.add(tfWeight);

        // ===== BUTTONS =====
        JButton btnCalculate = new JButton("Calculate BMI");
        btnCalculate.setBounds(50, 210, 150, 30);
        frame.add(btnCalculate);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(230, 210, 120, 30);
        frame.add(btnClear);

        // ===== OUTPUT =====
        lblBMI = new JLabel("BMI: ");
        lblBMI.setBounds(30, 260, 400, 25);
        frame.add(lblBMI);

        lblCategory = new JLabel("Category: ");
        lblCategory.setBounds(30, 300, 400, 25);
        frame.add(lblCategory);

        // ===== LOGIC =====
        btnCalculate.addActionListener(e -> {
            if (tfHeight.getText().isEmpty() || tfWeight.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all required fields!");
                return;
            }

            try {
                double height = Double.parseDouble(tfHeight.getText());
                double weight = Double.parseDouble(tfWeight.getText());

                if (height <= 0 || weight <= 0) {
                    JOptionPane.showMessageDialog(frame, "Height and weight must be greater than zero!");
                    return;
                }

                double bmi = weight / (height * height);
                lblBMI.setText("BMI: " + String.format("%.2f", bmi));

                if (bmi < 18.5) {
                    lblCategory.setText("Category: Underweight");
                } else if (bmi < 24.9) {
                    lblCategory.setText("Category: Normal Weight");
                } else if (bmi < 29.9) {
                    lblCategory.setText("Category: Overweight");
                } else {
                    lblCategory.setText("Category: Obese");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter valid numeric values!");
            }
        });

        btnClear.addActionListener(e -> {
            tfName.setText("");
            tfAge.setText("");
            tfHeight.setText("");
            tfWeight.setText("");
            lblBMI.setText("BMI: ");
            lblCategory.setText("Category: ");
        });
    }

    // ✅ MAIN METHOD (THIS FIXES THE PROBLEM)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BMICalculator().show();
        });
    }
}
