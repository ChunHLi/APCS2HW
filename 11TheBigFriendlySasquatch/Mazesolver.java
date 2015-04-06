import java.util.*;
import java.io.*;

public class Mazesolver{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private String clear =  "\033[2J";
    private String hide =  "\033[?25l";
    private String show =  "\033[?25h";
    private ArrayDeque<OP> frontier = new ArrayDeque<OP>();
    private int[] solutionCoordinates;
    
    public Mazesolver(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    
	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
	OP start = new OP(startx, starty,0);
	frontier.add(start);
	
    }
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }
    
    public void clearTerminal(){
	System.out.println(clear);
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public String toString(){
    	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
    	for(int i = 0; i < maxx * maxy; i++){
    	    if(i % maxx == 0 && i != 0){
    		ans += "\n";
    	    }
    	    char c =  maze[i % maxx][i / maxx];
    	    if(c == '#'){
    		ans += c;
    	    }else{
    		ans += c;
    	    }
    	}
    	return hide + go(0,0) + ans + "\n" + show + color(37,40);
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }
    
    public boolean solveBFS(boolean Animate){
	char[][] Maze = new char[maze.length][maze[0].length];
	OP placeHolder;
	int rowC = 0;
	int colC = 0;
	while (rowC < maze.length){
	    while (colC < maze[0].length){
		Maze[rowC][colC] = maze[rowC][colC];
		colC += 1;
	    }
	    rowC += 1;
	    colC = 0;
	}
	while (true == true){
	    if (Animate){
		System.out.println(toString());
		wait(20);
	    }
	    OP current = frontier.remove();
	    if (maze[current.getRow()][current.getCol()] == 'E'){
		placeHolder = current;
		break;
	    }
	    maze[current.getRow()][current.getCol()] = 'x';
	    if (maze[current.getRow() + 1][current.getCol()] == ' ' || maze[current.getRow() + 1][current.getCol()] == 'E'){
		OP nextMove = new OP(current.getRow() + 1,current.getCol(),current.getDistance() + 1, current);
		frontier.add(nextMove);
	    }
	    if (maze[current.getRow()][current.getCol() + 1] == ' ' || maze[current.getRow()][current.getCol() + 1] == 'E'){
		OP nextMove = new OP(current.getRow(),current.getCol() + 1, current.getDistance() + 1, current);
		frontier.add(nextMove);
	    }
	    if (maze[current.getRow() - 1][current.getCol()] == ' ' || maze[current.getRow() - 1][current.getCol()] == 'E'){
		OP nextMove = new OP(current.getRow() - 1,current.getCol(), current.getDistance() + 1, current);
		frontier.add(nextMove);
	    }
	    if (maze[current.getRow()][current.getCol() - 1] == ' ' || maze[current.getRow()][current.getCol() - 1] == 'E'){
		OP nextMove = new OP(current.getRow(), current.getCol() - 1,current.getDistance() +  1, current);
		frontier.add(nextMove);
	    }
	}
	frontier.clear();
	int size = (placeHolder.getDistance() + 1) * 2;
	solutionCoordinates = new int[size];
	size -= 1;
	while (size >= 0){
	    solutionCoordinates[size] = placeHolder.getCol();
	    size -= 1;
	    solutionCoordinates[size] = placeHolder.getRow();
	    size -= 1;
	    Maze[placeHolder.getRow()][placeHolder.getCol()] = 'x';
	    if (placeHolder.getPrevious() == null){
		break;
	    }
	    placeHolder = placeHolder.getPrevious();
	}
	maze = Maze;
	System.out.println(toString());
	return Animate;
    }
    
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveDFS(boolean Animate){
	char[][] Maze = new char[maze.length][maze[0].length];
	OP placeHolder;
	int rowC = 0;
	int colC = 0;
	while (rowC < maze.length){
	    while (colC < maze[0].length){
		Maze[rowC][colC] = maze[rowC][colC];
		colC += 1;
	    }
	    rowC += 1;
	    colC = 0;
	}
	while (true == true){
	    if (Animate){
		System.out.println(toString());
		wait(20);
	    }
	    OP current = frontier.removeLast();
	    if (maze[current.getRow()][current.getCol()] == 'E'){
		placeHolder = current;
		break;
	    }
	    maze[current.getRow()][current.getCol()] = 'x';
	    if (maze[current.getRow() + 1][current.getCol()] == ' ' || maze[current.getRow() + 1][current.getCol()] == 'E'){
		OP nextMove = new OP(current.getRow() + 1,current.getCol(),current.getDistance() + 1, current);
		frontier.add(nextMove);
	    }
	    if (maze[current.getRow()][current.getCol() + 1] == ' ' || maze[current.getRow()][current.getCol() + 1] == 'E'){
		OP nextMove = new OP(current.getRow(),current.getCol() + 1, current.getDistance() + 1, current);
		frontier.add(nextMove);
	    }
	    if (maze[current.getRow() - 1][current.getCol()] == ' ' || maze[current.getRow() - 1][current.getCol()] == 'E'){
		OP nextMove = new OP(current.getRow() - 1,current.getCol(), current.getDistance() + 1, current);
		frontier.add(nextMove);
	    }
	    if (maze[current.getRow()][current.getCol() - 1] == ' ' || maze[current.getRow()][current.getCol() - 1] == 'E'){
		OP nextMove = new OP(current.getRow(), current.getCol() - 1,current.getDistance() +  1, current);
		frontier.add(nextMove);
	    }
	}
	frontier.clear();
	int size = (placeHolder.getDistance() + 1) * 2;
	solutionCoordinates = new int[size];
	size -= 1;
	while (size >= 0){
	    solutionCoordinates[size] = placeHolder.getCol();
	    size -= 1;
	    solutionCoordinates[size] = placeHolder.getRow();
	    size -= 1;
	    Maze[placeHolder.getRow()][placeHolder.getCol()] = 'x';
	    if (placeHolder.getPrevious() == null){
		break;
	    }
	    placeHolder = placeHolder.getPrevious();
	}
	maze = Maze;
	System.out.println(toString());
	return Animate;
    }
    
    public int[] solutionCoordinates(){
	return solutionCoordinates;
    }
}
