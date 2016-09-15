package edu.jsu.mcis; 

public class TicTacToeModel{
	public int[][] grid; 
	private boolean playerX;  
	private boolean tieGame;
	public int turnCounter; 
	public String winMessage; 

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

	public String checkHorizonal(){ // this is not complete. How to convert bool to string?
		if(grid[0][0] == grid[0][1] && grid[0][0] == grid[0][2] && grid[0][0] != 0){
			winMessage = getMark(0,0); 
		}
		if(grid[1][0] == grid[1][1] && grid[1][0] == grid[1][2] && grid[1][0] != 0){
			winMessage = getMark(1,0);
		}
		if(grid[2][0] == grid[2][1] && grid[2][0] == grid[2][2] && grid[2][0] != 0){
			winMessage = getMark(2,0);
		}
		return winMessage;
	}

	public String checkVertical(){
		for(int i = 0; i < 3; i++){
			if(getMark(i, 0).equals("X") || getMark(i, 0).equals("O")){ 
				winMessage = getMark(i,0);
			}
			else if(getMark(i, 1).equals("X") || getMark(i, 1).equals("O")){
				winMessage = getMark(i,1);
			}
			else if(getMark(i, 2).equals("X") || getMark(i, 2).equals("O")){
				winMessage = getMark(i,2);
			}
		}
		return winMessage; 
	}

	public String checkDiagonal(){
		if(grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != 0){
			winMessage = getMark(0,0); 
		}
		else if(grid[2][0] == grid[1][1] && grid[2][0] == grid[0][2] && grid[2][0] != 0){
			winMessage = getMark(2,0); 
		}
		return winMessage; 
	}

	public String checkTieGame(){  
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(grid[i][j] == 2 || grid[i][j] == 1){
					winMessage = "TIE"; 
				}
			}
		}
		return winMessage; 
	}

	public String checkWinner(){
		if(turnCounter != 9){
			checkDiagonal();
			checkVertical();
			checkHorizonal();
		}		
		else if(turnCounter == 9){
			checkTieGame();
		}		 
		return winMessage; 
	}
}