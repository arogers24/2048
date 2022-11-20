//File: FinalProject/Grid.java
//Aidan Orr + Adam Rogers
//Contains all logic for 2048 game with int matrix

import java.util.*;
class Grid {
    int [][] grid = new int [4][4];
    int [][] tempGrid = new int [4][4];
    int score = 0;
    int temp;
    Grid () {
	this.grid = grid;
	this.tempGrid = tempGrid;
	this.score = score;
	this.temp = temp;
    }
    public void gridGen() {
	int mRow = (int) (Math.random() * 4);
	int mColumn = (int) (Math.random() * 4);
	int nRow = (int) (Math.random() * 4);
	int nColumn = (int) (Math.random() * 4);
	//randomly generate two numbers
	//generates a 4 10% of the time
	int mRandVal = (int) (Math.random() * 10);
	int nRandVal = (int) (Math.random() * 10);
	if (mRandVal == 0) grid[mRow][mColumn] = 4;
	else grid[mRow][mColumn] = 2;
	if (nRandVal == 0) grid[nRow][nColumn] = 4;
	else grid[nRow][nColumn] = 2;	
    }   //gridGen
    public int [][] tempGridGen() {
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		tempGrid[i][j] = grid[i][j];
	    }
	}   //set tempGrid to grid (before movement)
	return tempGrid;
    }   //tempGridGen
    public boolean checkEq(int [][] tempGrid) {
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (tempGrid[i][j] != grid[i][j]) return false;
	    }
	}   //check grid (after movement) and tempGrid equality
	return true;
    }   //checkEq
    public void left() {
	leftShift();
	leftCombo();
	leftShift();
    }   //left
    public void right() {
	rightShift();
	rightCombo();
	rightShift();
    }   //right
    public void up() {
	upShift();
	upCombo();
	upShift();
    }   //up
    public void down() {
	downShift();
	downCombo();
	downShift();
    }   //down
    public void leftShift() {
	for (int i = 0; i < 4; i++) {
	    for (int j = 1; j < 4; j++) {
		for (int n = 1; n <= j; n++) {
		    if (grid[i][j-n] == 0) {
			temp = grid[i][j-n+1];
			grid[i][j-n] = temp;
			grid[i][j-n+1] = 0;
		    }   //if square to left is 0, shift left
		}   //along row
	    }   //by column
	}   //by row
    }   //leftShift
    public void rightShift() {
	for (int i = 0; i < 4; i++) {
	    for (int j = 2; j >= 0 ; j--) {
		for (int n = 1; n < 4 - j; n++) {
		    if (grid[i][j+n] == 0) {
			temp = grid[i][j+n-1];
			grid[i][j+n] = temp;
			grid[i][j+n-1] = 0;
		    }   //if square to right is 0, shift right
		}   //along row
	    }   //by column
	}   //by row
    }   //rightShift
    public void upShift() {
	for (int i = 1; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		for (int n = 1; n <= i; n++) {
		    if (grid[i-n][j] == 0) {
			temp = grid[i-n+1][j];
			grid[i-n][j] = temp;
			grid[i-n+1][j] = 0;
		    }   //if square above is 0, shift up
		}   //along column
	    }   //by column
	}   //by row
    }   //upShift
    public void downShift() {
	for (int i = 2; i >= 0 ; i--) {
	    for (int j = 0; j < 4 ; j++) {
		for (int n = 1; n < 4 - i; n++) {
		    if (grid[i+n][j] == 0) {
			temp = grid[i+n-1][j];
			grid[i+n][j] = temp;
			grid[i+n-1][j] = 0;
		    }   //if square below is 0, shift down
		}   //along column
	    }   //by column
	}   //by row
    }   //downShift
    public void leftCombo() {
	for (int i = 0; i < 4; i++) {
	    for (int j = 1; j < 4; j++) {
		if (grid[i][j] == grid[i][j-1] && grid[i][j] != 0) {
		    temp = 2*grid[i][j];
		    grid[i][j-1] = temp;
		    grid[i][j] = 0;
		    score += temp;			    
		}   //if square to left is equal, make it double
	    }   //by column
	}   //by row
    }   //leftCombo
    public void rightCombo() {
	for (int i = 0; i < 4; i++) {
	    for (int j = 2; j >= 0; j--) {
		if (grid[i][j] == grid[i][j+1] && grid[i][j] != 0) {
		    temp = 2*grid[i][j];
		    grid[i][j+1] = temp;
		    grid[i][j] = 0;
		    score += temp;
		}   //if square to right is equal, make it double
	    }   //by column
	}   //by row
    }   //rightCombo
    public void upCombo() {
	for (int i = 1; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (grid[i][j] == grid[i-1][j] && grid[i][j] != 0) {
		    temp = 2*grid[i][j];
		    grid[i-1][j] = temp;
		    grid[i][j] = 0;
		    score += temp;
		}   //if square above is equal, make it double
	    }   //by column
	}   //by row
    }   //upCombo
    public void downCombo() {
	for (int i = 2; i >= 0 ; i--) {
	    for (int j = 0; j < 4; j++) {
		if (grid[i][j] == grid[i+1][j] && grid[i][j] != 0) {
		    temp = 2*grid[i][j];
		    grid[i+1][j] = temp;
		    grid[i][j] = 0;
		    score += temp;
		}   //if square below is equal, make it double
	    }   //by column
	}   //by row
    }   //downCombo
    public void genBlock() {
	ArrayList <Integer> empty = new ArrayList<> ();
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (grid[i][j] == 0) empty.add(0);
	    }
	}   //add 0s to ArrayList of size (# of empty spaces)
	int rand = (int) (Math.random() * empty.size() + 1);   //gen # from 1 to ArrayList size	
	int counter = 0;
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (grid[i][j] == 0) counter++;
		if (counter == rand) {
		    //generate a 4 10% of the time
		    int n = (int) (Math.random() * 10);
		    if (n == 0) grid[i][j] = 4;
		    else grid[i][j] = 2;
		    counter = 2049;   //set to an unachievable number -- avoids adding multiple 2s
		    break;
		}   //generate 2 at (rand)th empty space
	    }   //by column
	}   //by row
    }   //genBlock
    public boolean checkGameOver () {
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (grid[i][j] == 0) return false;
	    }
	}   //return false if grid has empty square
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 3; j++) {
		if (grid[i][j] == grid [i][j+1]) return false;
	    }
	}   //return false if grid has equal neighbors
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 4; j++) {
		if (grid[i][j] == grid [i+1][j]) return false;
	    }
	}   //return false if grid has equal neighbors
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (grid[i][j] == 2048) return false;
	    }
	}   //return false if player gets 2048
	return true;
    }   //checkGameOver
    public int scoreTotal() {
	return score;
    }   //scoreTotal
    public void printGrid() {
        Square Square1 = new Square();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j] > 0) {
                    Square1.value(grid[i][j]);
                    Square1.draw();
                }
                if(Square1.getX() < 600) {
                    Square1.changeX(120);
                }
            }   //by column
            Square1.changeX(-360);
            Square1.changeY(120);
        }   //by row
    }   //printGrid
}   //class
