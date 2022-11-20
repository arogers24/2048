//File: FinalProject/main.java
//Aidan Orr + Adam Rogers
//Main method -- includes game loop and writing scores to file

import java.util.*;
import java.awt.*;
import java.io.*;
public class main {
    public static void main(String[] args) {
	StdDraw.enableDoubleBuffering(); //Allows for animation
        StdDraw.setScale(0,1000);
	while (true) {
	    game();
	}   //loop game
    }   //main
    static void game() {
	File f = new File("myscores.txt");	
	Scanner fin = null;
	FileWriter fw = null;
	PrintWriter fout = null;
	try {
	    fin = new Scanner(new FileReader(f));
	    fw = new FileWriter(f, true);
	    fout = new PrintWriter(fw);
	}   //try
	catch (Exception ex) {
	    System.out.println(ex);
	}   //catch exception	
	ArrayList <Integer> scoresList = new ArrayList <> ();
	int highScore;
        while (fin.hasNext()) {
	    scoresList.add(fin.nextInt());
	}   //reads file by line, adding to ArrayList
	highScore = Collections.max(scoresList);
	fin.close();

	int keypressed = 0;        
	Grid grid = new Grid ();
	Square.drawBoard();
	StdDraw.show();
	StdDraw.text(695,840, Integer.toString(highScore));
        grid.gridGen();
	grid.printGrid();
        while (! grid.checkGameOver()) {
	    int [][] tempGrid = grid.tempGridGen();
	    Font score = new Font("Arial", Font.BOLD, 10);
	    StdDraw.setFont(score);
	    StdDraw.setPenColor(93,60,133);
	    if(StdDraw.isMousePressed() && (580 < StdDraw.mouseX()) && (StdDraw.mouseX() < 720) && (StdDraw.mouseY() < 780) && (StdDraw.mouseY() > 720)) {
                Square.drawBoard();
                StdDraw.pause(200);
                game();
            }   //if "New Game" is clicked
	    if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT)) {
                Square.drawBoard();
                grid.left();
		StdDraw.text(600,840, Integer.toString(grid.scoreTotal()));
		StdDraw.text(695,840, Integer.toString(highScore));
                keypressed = java.awt.event.KeyEvent.VK_LEFT;
                if (! grid.checkEq(tempGrid)) grid.genBlock();   //if grid after movement is same, don't add new block
                StdDraw.pause(100);
            }   //if left arrow is pressed
            if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT)) {
                Square.drawBoard();
                grid.right();
		StdDraw.text(600,840, Integer.toString(grid.scoreTotal()));
		StdDraw.text(695,840, Integer.toString(highScore));
                keypressed = java.awt.event.KeyEvent.VK_RIGHT;
                if (! grid.checkEq(tempGrid)) grid.genBlock();   //if grid after movement is same, don't add new block
                StdDraw.pause(100);
            }   //if right arrow is pressed
            if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP)) {
		Square.drawBoard();
                grid.down();
		StdDraw.text(600,840, Integer.toString(grid.scoreTotal()));
		StdDraw.text(695,840, Integer.toString(highScore));
                keypressed = java.awt.event.KeyEvent.VK_UP;
                if (! grid.checkEq(tempGrid)) grid.genBlock();   //if grid after movement is same, don't add new block
                StdDraw.pause(100);
            }   //if down arrow is pressed
            if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN)) {
                Square.drawBoard();
                grid.up();
		StdDraw.text(600,840, Integer.toString(grid.scoreTotal()));
		StdDraw.text(695,840, Integer.toString(highScore));
                keypressed = java.awt.event.KeyEvent.VK_DOWN;
                if (! grid.checkEq(tempGrid)) grid.genBlock();   //if grid after movement is same, don't add new block
                StdDraw.pause(100);
            }	//if down arrow is pressed   
	    if(StdDraw.isMousePressed() && (280 < StdDraw.mouseX()) && (StdDraw.mouseX() < 420) && (StdDraw.mouseY() < 180) && (StdDraw.mouseY() > 120)) {
                StdDraw.clear(StdDraw.WHITE);
                Font instructions = new Font("Arial", Font.BOLD, 20);
                StdDraw.setFont(instructions);
                StdDraw.text(500,600,"Use your arrow-keys to move the tiles.");
                StdDraw.text(500,500,"When two tiles with the same number touch,");
                StdDraw.text(500,400,"they merge into one!");
                StdDraw.show();
                StdDraw.pause(5000);
                StdDraw.clear();
                Square.drawBoard();
            }   //if "Instructions" is clicked
            grid.printGrid();
            StdDraw.show();
        }   //loop while game is not over
	scoresList.add(grid.scoreTotal());
	fout.write(grid.scoreTotal() + "\n");   //write score to txt file
	fout.close();
	StdDraw.text(695,840, Integer.toString(highScore));
	StdDraw.pause(3000);
	StdDraw.clear();
	StdDraw.text(500,600, "Game Over!!");
	StdDraw.text(500,400, "New Game starting in: ");
	StdDraw.show();
	StdDraw.pause(3000);
	StdDraw.clear();
	StdDraw.text(450,500, "3");
	StdDraw.show();
	StdDraw.pause(1000);
	StdDraw.text(500,500, "2");
	StdDraw.show();
	StdDraw.pause(1000);
	StdDraw.text(550,500, "1");
	StdDraw.show();
	StdDraw.pause(1000);
    }   //game
}   //class
