package edu.jsu.mcis; 

public class TicTacToeModel{
	public int[][] grid; 
	private boolean gameOn;
	private boolean playerX; 
	private boolean gameWon; 
	private boolean tieGame;
	public int turnCounter; 

	public TicTacToeModel(){
		grid = new int[3][3];
		turnCounter = 0; 
	}

	public String getMark(int row, int col){
		if(grid[row][col] == 0){
			return "";
		}
		else if(grid[row][col] == 1){
			return "X";
		}
		else return "O";
	}

	public void makeMark(String mark, int row, int col){
		if(grid[row][col] == 0){
			if(mark.equals("X")){
				grid[row][col] = 1;
			}
			else if(mark.equals("O")){
				grid[row][col] = 2; 
			}
			else if(mark.equals("")){
				grid[row][col] = 0; 
			}
			turnCounter++;
		}
	}

	public boolean checkGamePlaying(){
		if(turnCounter == 9){
			return false;
		}
		else return true; 
	}

	public boolean checkPlayer(){
		if(playerX){
			return true; 
		}
		else return false; 
	}

	public boolean checkHorizonal(){
		for(int j = 0; j < 3; j++){
			if(getMark(0, j).equals("X") || getMark(0, j).equals("O")){
				gameWon = true;
			}
			else if(getMark(1, j).equals("X") || getMark(1, j).equals("O")){
				gameWon = true; 
			}
			else if(getMark(2, j).equals("X") || getMark(2, j).equals("O")){
				gameWon = true; 
			}
			else gameWon = false; 
		}
		return gameWon;
	}

	public boolean checkVertical(){
		for(int i = 0; i < 3; i++){
			if(getMark(i, 0).equals("X") || getMark(i, 0).equals("O")){
				gameWon = true; 
			}
			else if(getMark(i, 1).equals("X") || getMark(i, 1).equals("O")){
				gameWon = true; 
			}
			else if(getMark(i, 2).equals("X") || getMark(i, 2).equals("O")){
				gameWon = true; 
			}
			else gameWon = false; 
		}
		return gameWon; 
	}

	public boolean checkTieGame(){  
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(grid[i][j] == 2){
					tieGame = false; 
				}
			}
		}
		return true; 
	}
}