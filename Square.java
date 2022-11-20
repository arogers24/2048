//File: FinalProject/Square.java
//Aidan Orr + Adam Rogers
//Draw functions for 2048

import java.awt.*;
public class Square {
    private double x;
    private double y;
    private double width;
    private int value;
    private Grid grid;
    public Square() {
        x = 320;
        y = 270;
        width = 50;
    }
    public void changeX(double x) {
        this.x = this.x + x;
    }
    public double getX() {
        return x;
    }
    public static void drawBoard() {
        Font game = new Font("Arial", Font.BOLD, 50);
        Font game2 = new Font("Arial", Font.BOLD, 10);
        StdDraw.setFont(game);
       
        StdDraw.setPenColor(93,60,133); //Mammoth Purple Dusk
        StdDraw.text(360,800,"2048");

        StdDraw.filledRectangle(600,850,35,30); //Score
        StdDraw.filledRectangle(695,850,50,30); //Best Score
        StdDraw.filledRectangle(650,750,70,30); //New Game Button
        StdDraw.filledRectangle(350,150,70,30); //Instructions Button

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(game2);
        StdDraw.text(650,750,"New Game");
        StdDraw.text(695,860,"Best");
        StdDraw.text(600,860,"Score");
        StdDraw.text(350,150,"Instructions");

        StdDraw.setPenColor(93,60,133); //Mammoth Purple Dusk
        StdDraw.filledSquare(500,450,250); //Outer Game Square

        StdDraw.setPenColor(133,108,176); //Mammoth Purple Light
        StdDraw.filledSquare(500,450,230); //Inner Game Square

        StdDraw.setPenColor(93,60,133); //Mammoth Purple Dusk
        StdDraw.filledRectangle(500,450,10,230); //Middle Width Length Bar
        StdDraw.filledRectangle(620,450,10,230);
        StdDraw.filledRectangle(380,450,10,230);
        StdDraw.filledRectangle(500,450,230,10); //Middle Width Dividing Bar
        StdDraw.filledRectangle(500,570,230,10);
        StdDraw.filledRectangle(500,330,230,10);

	//Draws all of the background squares in the board
	StdDraw.setPenColor(StdDraw.BLACK); //Mammoth Purple Dusk

        StdDraw.filledSquare(560,510,50);
        StdDraw.filledSquare(560,630,50);
        StdDraw.filledSquare(440,510,50);
        StdDraw.filledSquare(440,630,50);

        StdDraw.filledSquare(560,390,50);
        StdDraw.filledSquare(560,270,50);
        StdDraw.filledSquare(440,390,50);
        StdDraw.filledSquare(440,270,50);

        StdDraw.filledSquare(680,510,50);
        StdDraw.filledSquare(680,630,50);
        StdDraw.filledSquare(320,510,50);
        StdDraw.filledSquare(320,630,50);

        StdDraw.filledSquare(680,390,50);
        StdDraw.filledSquare(680,270,50);
        StdDraw.filledSquare(320,390,50);
        StdDraw.filledSquare(320,270,50);

        StdDraw.show();
    }
    public double getY() {
        return y;
    }
    public void changeY(double y) {
        this.y = this.y + y;
    }
    public void value(int value) {
        this.value = value;
    }
    public void draw() {
        switch(value) { //Depending on the value of the square, it will be painted a different color, with darker colors of blue corresponding to higher scores!  
            case(2): StdDraw.setPenColor(230,242,255); break;
            case(4): StdDraw.setPenColor(195,223,255); break;
            case(8): StdDraw.setPenColor(129,188,255); break;
            case(16): StdDraw.setPenColor(92,169,255); break;
            case(32): StdDraw.setPenColor(60,155,255); break;
            case(64): StdDraw.setPenColor(40,141,255); break;
            case(128): StdDraw.setPenColor(0,119,255); break;
            case(256): StdDraw.setPenColor(0,105,255); break;
            case(512): StdDraw.setPenColor(0,90,193); break;
            case(1024): StdDraw.setPenColor(0,78,166); break;
            case(2048): StdDraw.setPenColor(0,62,132); break;
        }
        StdDraw.filledSquare(x,y,width);
        StdDraw.setPenColor(StdDraw.BLACK);
        Font square = new Font("Arial", Font.BOLD, 18);
        StdDraw.setFont(square);
        StdDraw.text(x,y,Integer.toString(value));
    }
}
