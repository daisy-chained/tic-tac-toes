import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Scanner;

public class Application implements Runnable {

    public static void main(String[] args) {
        SaxionApp.start(new Application(), 1024, 768);
    }

    public void run() {
        int move;
        int ticker = 0;
        int player = 1;
        int[] storage = new int[10];
        int size = 100;
        int sizeBall = 50;
        int moveCoordsX = 100;
        int moveCoordsY = 100;
        boolean gameOver = false;
        SaxionApp.drawLine(150, 50, 150, 350);
        SaxionApp.drawLine(250, 50, 250, 350);
        SaxionApp.drawLine(50, 150, 350, 150);
        SaxionApp.drawLine(50, 250, 350, 250);
        SaxionApp.setTextDrawingColor(Color.black);
        SaxionApp.drawText("1",80,50,size);
        SaxionApp.drawText("2",180,50,size);
        SaxionApp.drawText("3",280,50,size);
        SaxionApp.drawText("4",80,150,size);
        SaxionApp.drawText("5",180,150,size);
        SaxionApp.drawText("6",280,150,size);
        SaxionApp.drawText("7",80,250,size);
        SaxionApp.drawText("8",180,250,size);
        SaxionApp.drawText("9",280,250,size);
        SaxionApp.setTextDrawingColor(Color.BLUE);
        SaxionApp.setFill(Color.BLUE
        );

        while (gameOver == false && ticker<9) {
            SaxionApp.print("where");
            move = SaxionApp.readInt();
            //valid move check
            if (move < 1 && move > 9) {
                SaxionApp.printLine("invalid answer");} else if (storage[move] == 1 || storage[move] == 2) {SaxionApp.printLine("spot taken");}
            else{
                //recording the move for win condition check
                storage[move] = player;
                //going from location pick to draw location
                switch (move) {
                    case 1:
                        moveCoordsX = 100;
                        moveCoordsY = 100;
                        break;
                    case 2:
                        moveCoordsX = 200;
                        moveCoordsY = 100;
                        break;
                    case 3:
                        moveCoordsX = 300;
                        moveCoordsY = 100;
                        break;
                    case 4:
                        moveCoordsX = 100;
                        moveCoordsY = 200;
                        break;
                    case 5:
                        moveCoordsX = 200;
                        moveCoordsY = 200;
                        break;
                    case 6:
                        moveCoordsX = 300;
                        moveCoordsY = 200;
                        break;
                    case 7:
                        moveCoordsX = 100;
                        moveCoordsY = 300;
                        break;
                    case 8:
                        moveCoordsX = 200;
                        moveCoordsY = 300;
                        break;
                    case 9:
                        moveCoordsX = 300;
                        moveCoordsY = 300;
                        break;
                    default:
                        break;
                }
                //x and o drawing
                if (player == 1) {SaxionApp.drawCircle(moveCoordsX, moveCoordsY, sizeBall);}
                if (player == 2) {SaxionApp.drawText("x", (moveCoordsX - 20), (moveCoordsY - 50), size);}
                //win condition check in order rows, diag, then collums
                if (storage[1] == player && storage[2] == player && storage[3] == player) {gameOver = true;}
                if (storage[4] == player && storage[5] == player && storage[6] == player) {gameOver = true;}
                if (storage[7] == player && storage[8] == player && storage[9] == player) {gameOver = true;}
                //diag
                if (storage[1] == player && storage[5] == player && storage[9] == player) {gameOver = true;}
                if (storage[3] == player && storage[5] == player && storage[7] == player) {gameOver = true;}
                //collumns
                if (storage[1] == player && storage[4] == player && storage[7] == player) {gameOver = true;}
                if (storage[2] == player && storage[5] == player && storage[8] == player) {gameOver = true;}
                if (storage[3] == player && storage[6] == player && storage[9] == player) {gameOver = true;}
                ticker++;
                if (player == 1) {player = 2;} else{player = 1;}
            }
            //doing conversion to acurate player selection
            // TODO figure out when player conversion can happen.
        }if (player == 1) {player = 2;} else{player = 1;}
        if(ticker == 9){
            SaxionApp.printLine("out of moves");
        } else{ SaxionApp.printLine("Player " + player + " won"); }

        SaxionApp.print("game over");

    }}








