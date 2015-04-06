import java.util.*;

public class Driver{

    public static void main(String[]args){
	Mazesolver f;
	Mazesolver g;
	if(args.length < 1){
	    f = new Mazesolver("data1.dat");
	    g = new Mazesolver("data1.dat");
	}else{
	    f = new Mazesolver(args[0]);
	    g = new Mazesolver(args[0]);
	}
	f.solveBFS(true);
	System.out.println(Arrays.toString(f.solutionCoordinates()));
	f.wait(5000);
	g.solveDFS(true);
	System.out.println(Arrays.toString(g.solutionCoordinates()));
    }
    
}
