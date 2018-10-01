import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class GuessingGame extends JFrame {
	private JTextField txtGuess; // text field for the user's guess
	private JLabel lblOutput; // label for too high/too low output
	private int theNumber;	// the number we'r trying to guess
	private int triesleft = 7; // give the user 7 tries
	
	public void checkGuess() { // method/function to check too high or too low
		// get the user's guess
		String guessText = txtGuess.getText();
		String message = "";
		
		
		try {
			// check the guess for too high/too low
			int guess = Integer.parseInt(guessText);
			
			// count this as one try;
			triesleft--;
			
			if (guess > theNumber) {
				message = guess + " was too high. Guess again!";
				message += "You have " + triesleft + " tries left.";
				lblOutput.setText(message);
			}
			else if (guess < theNumber) {
				message = guess + " was too low. Guess again!";
				message += "You have " + triesleft + " tries left.";
				lblOutput.setText(message);
			}
			else {
				message = guess + " was right. You win. Let's play again!";
				lblOutput.setText(message);
				newGame();
			}
			
			if(triesleft <= 0) {
				javax.swing.JOptionPane.showConfirmDialog(null, 
						"Sorry, you rant out of tries, The number was " + theNumber + ". Play again!");
				newGame();
			}
		}
		catch(Exception e) {
			lblOutput.setText("Enter a whole number between 1 and 100.");
		}
		finally {
			txtGuess.requestFocus();
			txtGuess.selectAll();	
		}
	}
	
	public void newGame() { // create a new random number 1..100
		theNumber = (int)(Math.random()*100 + 1);
		triesleft = 7;
	}
	
	public GuessingGame() {
		setTitle("Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblRomainTestard = new JLabel("Romain Testard - Guessing Game");
		lblRomainTestard.setBounds(10, 7, 434, 44);
		lblRomainTestard.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblRomainTestard.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblRomainTestard);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 66, 412, 43);
		getContentPane().add(panel);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		panel.add(lblGuessANumber);
		lblGuessANumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btn = new JButton("Guess!");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btn.setBounds(159, 133, 107, 37);
		getContentPane().add(btn);
		
		lblOutput = new JLabel("Enter a number above. You have 7 tries.");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 201, 412, 31);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430,330));
		theGame.setVisible(true);
	}
}
