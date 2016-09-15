package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	private JButton[][] grid;
	private boolean xTurn;

	public GUI(){
		xTurn = true;
		setLayout(new GridLayout(3,3));
		grid = new JButton[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				grid[i][j] = new JButton();
				grid[i][j].addActionListener(this);
				add(grid[i][j]);
			}
		}
	}
	
	public void actionPerformed(ActionEvent event){
		JButton b = (JButton)event.getSource();
		if (b.getText().length() == 0){
			if(xTurn){b.setText("X");}
			else{b.setText("O");}
			xTurn = !xTurn;
		}		
	}
}
