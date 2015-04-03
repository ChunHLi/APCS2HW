import java.util.*;

public class Driver{

    public static void main(String[]args){
	Mazesolver f;
	if(args.length < 1){
	    f = new Mazesolver("data1.dat");
	}else{
	    f = new Mazesolver(args[0]);
	}
	f.clearTerminal();
	f.solveBFS(true);
	System.out.println(Arrays.toString(f.solutionCoordinates()));
    }
    
}
