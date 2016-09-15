package edu.jsu.mcis;

 import javax.swing.JFrame; 

public class TicTacToe{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tic Tac Toe");
		GUI window = new GUI();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setSize(350, 350);
		window.setVisible(true);
	}
}
