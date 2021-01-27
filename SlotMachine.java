/*
// SlotMachine.java
// CS257 Lab 4
// Originally written by: Kevin Sahr, 4/28/19
// Update by: Maggie Vanderberg Winter 2020
*/
/*******************************
 * Edited By: Liam Erickson 
 * Class: CS257 - Maggie Vanderberg - Lab 8 
 * Date: March 4, 2020
 ********************************/

/*******************************
 * Edited By: Liam Erickson 
 * Class: CS257 - Maggie Vanderberg - Lab 9 
 * Date: March 13, 2020
 ********************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SlotMachine extends JFrame implements ActionListener {

	//// constants ////
	public static final int MAX_BET = 4;
	public static final int MAX_ROLL = 5;
	public static final int ALL_ZERO_MULTIPLIER = 10;
	public static final int TRIPLE_MULTIPLIER = 5;
	public static final int PAIR_MULTIPLIER = 3;
	/// other static variables ///
	private static int winnings = 0;
	private static int won = 0;
	//// instance variables ////
	private int bet = 0;
	private int r1 = 0;
	private int r2 = 0;
	private int r3 = 0;

	private void betOneCoin() {

		// if bet is == to max do not increase bet, else increase bet
		bet++;

		pullButton.setEnabled(true);

		if (bet == MAX_BET)
			betButton.setEnabled(false);

		displayNums();

	} // betOneCoin method

	private void pullHandle() {

		spinReels();

		// three of a kind
		if (r1 == r2 && r2 == r3) {
			if (r1 == 0) { // all zeros is biggest winner
				won = ALL_ZERO_MULTIPLIER * bet;
				winnings += won;
			} else { // all the same but not zero is also a winner
				won = TRIPLE_MULTIPLIER * bet;
				winnings += won;
			}
		} // if all same
		else if (r1 == r2 || r1 == r3 || r2 == r3) {// two of a kind
			won = PAIR_MULTIPLIER * bet;
			winnings += won;
		}
		// always clear bet after handle is pulled
		bet = 0;

		betButton.setEnabled(true);
		pullButton.setEnabled(false);

		displayNums();

	} // else pull handle

	// support methods

	private void spinReels() {
		// use one random object three time to generate random number
		// MAX_ROLL+1 is used because nextInt takes an exclusive upperbound
		Random rnd = new Random();
		r1 = rnd.nextInt(MAX_ROLL + 1);
		r2 = rnd.nextInt(MAX_ROLL + 1);
		r3 = rnd.nextInt(MAX_ROLL + 1);
	}

	private JLabel infoText;
	private JLabel r1Label;
	private JLabel r2Label;
	private JLabel r3Label;
	private JButton betButton;
	private JButton pullButton;
	private JButton resetButton;

	public SlotMachine() {

		Font myFont = new Font("Comic Sans MS", Font.BOLD, 50);
		// reels
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.CYAN);

		r1Label = new JLabel();
		r1Label.setOpaque(true);
		r1Label.setBackground(Color.cyan);
		textPanel.add(r1Label);
		r1Label.setFont(myFont);

		r2Label = new JLabel();
		r2Label.setOpaque(true);
		r2Label.setBackground(Color.cyan);
		textPanel.add(r2Label);
		r2Label.setFont(myFont);

		r3Label = new JLabel();
		r3Label.setOpaque(true);
		r3Label.setBackground(Color.cyan);
		textPanel.add(r3Label);
		r3Label.setFont(myFont);

		// Info
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.cyan);

		infoText = new JLabel();
		infoText.setBackground(Color.cyan);
		infoText.setOpaque(true);
		infoPanel.add(infoText);
		infoText.setFont(myFont);

		// buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.cyan);

		betButton = new JButton("Bet Coin");
		betButton.addActionListener(this);
		betButton.setBackground(Color.green);
		betButton.setOpaque(true);
		buttonPanel.add(betButton);
		betButton.setFont(myFont);

		pullButton = new JButton("Pull Handle");
		pullButton.addActionListener(this);
		pullButton.setBackground(Color.green);
		pullButton.setOpaque(true);
		buttonPanel.add(pullButton);
		pullButton.setFont(myFont);

		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		resetButton.setBackground(Color.green);
		resetButton.setOpaque(true);
		buttonPanel.add(resetButton);
		resetButton.setFont(myFont);

		resetNums();

		setBackground(Color.black);
		setLayout(new BorderLayout());
		add(infoPanel, BorderLayout.CENTER);
		add(textPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}// end SlotMachine

	private void displayNums() {

		infoText.setText("Bet: " + bet + " You Won: " + won + " Total: " + winnings);
		r1Label.setText("" + r1);
		r2Label.setText("" + r2);
		r3Label.setText("" + r3);

	} // end displayNums

	private void resetNums() {

		r1 = 0;
		r2 = 0;
		r3 = 0;
		bet = 0;
		won = 0;
		winnings = 0;
		pullButton.setEnabled(false);
		resetButton.setEnabled(true);
		betButton.setEnabled(true);

		displayNums();

	} // end resetNums

	@Override
	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();
		if (src == resetButton)
			resetNums();
		else if (src == betButton)
			betOneCoin();
		else if (src == pullButton)
			pullHandle();

	} // end actionPerformed

} // end SlotMachine
