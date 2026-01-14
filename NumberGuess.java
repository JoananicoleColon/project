package colon2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class NumberGuess {

	private JFrame frame;
	private JTextField txtPutYourGuess;
	private JButton btnCheckGuess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberGuess window = new NumberGuess();
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
	public NumberGuess() {
		initialize();
		createEvent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCheckGuess = new JButton("Check The Number");
		btnCheckGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		btnCheckGuess.setBackground(Color.WHITE);
		btnCheckGuess.setBounds(144, 168, 164, 23);
		frame.getContentPane().add(btnCheckGuess);
		
		txtPutYourGuess = new JTextField();
		
		txtPutYourGuess.setText("Put Your Guess Herer");
		txtPutYourGuess.setBounds(159, 128, 123, 29);
		frame.getContentPane().add(txtPutYourGuess);
		txtPutYourGuess.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Guess The Number!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(110, 29, 236, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pick a number from 1 to 10");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(123, 94, 223, 23);
		frame.getContentPane().add(lblNewLabel_1);
	}
	 private void createEvent() { 
		 txtPutYourGuess.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					txtPutYourGuess.setText(null);
				}
			});
		
		 txtPutYourGuess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Random r = new Random();
					int low = 1;
					int high = 11;
					int guess;
					int result = r.nextInt(high-low) + low;
					if (txtPutYourGuess.getText().isEmpty()) {
						JOptionPane.showInternalMessageDialog(
								null, "PROVIDE NUMBER!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {
					 guess = Integer.parseInt(txtPutYourGuess.getText());
				}
				if(guess < low || guess > high) {
					JOptionPane.showInternalMessageDialog(
							null, "PROVIDE NUMBER!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					txtPutYourGuess.setText(null);
				return;
				}
				if (guess == result) {JOptionPane.showInternalMessageDialog(
						null, "PROVIDE NUMBER!", "Alert", JOptionPane.INFORMATION_MESSAGE);
				} else if(guess < result) {JOptionPane.showInternalMessageDialog(
						null, "PROVIDE NUMBER!", "Alert", JOptionPane.INFORMATION_MESSAGE);
					
				}	
					JOptionPane.showInternalMessageDialog(
					null, result, "Alert", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});

	 }
}
