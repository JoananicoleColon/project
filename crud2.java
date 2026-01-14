package colon2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class crud2 {

    private JFrame frame;
    private JTextField tfID, tfName, tfAge;
    private JComboBox<String> cbDiagnosis;
    private JTable table;
    private DefaultTableModel model;

    public crud2() {
        initialize();
    }

    public void show() {
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("Clinic Patient Record System");
        frame.setBounds(100, 100, 850, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //INPUT FIELDS
        JLabel lblID = new JLabel("Patient ID");
        lblID.setBounds(30, 40, 100, 20);
        frame.add(lblID);

        tfID = new JTextField();
        tfID.setBounds(130, 40, 180, 25);
        frame.add(tfID);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 80, 100, 20);
        frame.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(130, 80, 180, 25);;
        frame.add(tfName);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(30, 120, 100, 20);
        frame.add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(130, 120, 180, 25);
        frame.add(tfAge);

        JLabel lblDiagnosis = new JLabel("Diagnosis");
        lblDiagnosis.setBounds(30, 160, 100, 20);
        frame.add(lblDiagnosis);

        String[] diagnoses = {
                "Select Diagnosis",
                "Flu",
                "Fever",
                "Tummyache",
                "Headache",
                "Cold",
                "Hypertension",
                "Diabetes",
                "Asthma",
                "Covid-19",
                "Allergy"
        };

        cbDiagnosis = new JComboBox<>(diagnoses);
        cbDiagnosis.setBounds(130, 160, 180, 25);
        frame.add(cbDiagnosis);

        //TABLE
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(330, 40, 330, 350);
        frame.add(scrollPane);

        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Patient ID", "Name", "Age", "Diagnosis"}
        );

        table = new JTable(model);
        scrollPane.setViewportView(table);

        //BUTTONS
        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(700, 80, 100, 30);
        frame.add(btnCreate);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(700, 130, 100, 30);
        frame.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(700, 180, 100, 30);
        frame.add(btnDelete);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(700, 230, 100, 30);
        frame.add(btnClear);

        //LOGIC

        //CREATE
        btnCreate.addActionListener(e -> {
            if (tfID.getText().isEmpty() ||
                tfName.getText().isEmpty() ||
                tfAge.getText().isEmpty() ||
                cbDiagnosis.getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(frame, "Fill all fields!");
                return;
            }

            model.addRow(new Object[]{
                    tfID.getText(),
                    tfName.getText(),
                    tfAge.getText(),
                    cbDiagnosis.getSelectedItem().toString()
            });
        });

        //UPDATE
        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.setValueAt(tfID.getText(), row, 0);
                model.setValueAt(tfName.getText(), row, 1);
                model.setValueAt(tfAge.getText(), row, 2);
                model.setValueAt(cbDiagnosis.getSelectedItem().toString(), row, 3);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a record!");
            }
        });

        //DELETE
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a record!");
            }
        });

        //CLEAR
        btnClear.addActionListener(e -> {
            tfID.setText("");
            tfName.setText("");
            tfAge.setText("");
            cbDiagnosis.setSelectedIndex(0);
        });

        //TABLE CLICK
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                tfID.setText(model.getValueAt(row, 0).toString());
                tfName.setText(model.getValueAt(row, 1).toString());
                tfAge.setText(model.getValueAt(row, 2).toString());
                cbDiagnosis.setSelectedItem(model.getValueAt(row, 3).toString());
            }
        });
    }
}