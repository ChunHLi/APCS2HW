import java.util.*;
import java.io.*;
import java.util.Arrays;

public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	int counter = 0;
	while (counter < board.length){
	    int counter2 = 0;
	    while (counter2 < board.length){
		ans += " " + board[counter][counter2];
		counter2 += 1;
	    }
	    ans += "\n";
	    counter += 1;
	}
	return hide + go(0,0) + clear + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
	int counter = 0;
	while (counter< size){
	    int counter2 = 0;
	    while (counter2 < size){
		board[counter][counter2] = 0;
		counter2 += 1;
	    }
	    counter += 1;
	}
    }

    
    public void solve(){
        if (solve(0,0,0)){
	}
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(20);
	
	if (currentMoveNumber >= board.length*board.length){
	    return false;
	}
	if (x < 0 || y < 0 || x >= board.length || y >= board[0].length){
	    return false;
	}
	if (board[x][y] != 0){
	    return false;
	}
	if (board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if (currentMoveNumber == board.length*board.length){
		return true;
	    }
	}
	
	if (solve(x-2,y-1,currentMoveNumber+1)||solve(x-2,y+1,currentMoveNumber+1)||solve(x+2,y-1,currentMoveNumber+1)||solve(x+2,y+1,currentMoveNumber+1)||solve(x-1,y-2,currentMoveNumber+1)||solve(x-1,y+2,currentMoveNumber+1)||solve(x+1,y-2,currentMoveNumber+1)||solve(x+1,y+2,currentMoveNumber+1)){
	    return true;
	}
	//board[x][y] = 0;
	return false;
    }
    public static void main(String[]args){
	KnightsTour b = new KnightsTour(6);
	b.solve();
	System.out.println(b);
    }
}
