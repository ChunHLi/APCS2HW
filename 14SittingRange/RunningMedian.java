import java.util.*;

public class RunningMedian{

    MyHeap Larger;
    MyHeap Smaller;
    ArrayList<Integer> Median;
    
    public static void main(String[]args){
	RunningMedian SittingRange = new RunningMedian();
	SittingRange.add(0);
	System.out.println(SittingRange.toString());
    }

    public RunningMedian(){
	Larger = new MyHeap(false);
	Smaller = new MyHeap(true);
	Median = new ArrayList<Integer>(0);
    }

    public void add(int addition){
	if (Median.size() == 0){
	    Median.add(addition);
	}
	else if (Median.size() == 1){
	    if (Median.get(0) < addition){
		Median.add(addition);
	    }
	    else{
		Median.add(0,addition);
	    }
	}
	else{
	    if (addition > Median.get(0) && addition < Median.get(1)){
		Smaller.add(Median.remove(0));
		Larger.add(Median.remove(0));
		Median.add(addition);
	    }
	    else if (addition > Median.get(0) && addition > Median.get(1)){
		Smaller.add(Median.remove(0));
		Larger.add(addition);
	    }
	    else{
		Smaller.add(addition);
		Larger.add(Median.remove(1));
	    }
	}
    }
    public double getMedian(){
	if (Median.size() == 0){
	    throw new NoSuchElementException();
	}
	else if (Median.size() == 1){
	    return (double)Median.get(0);
	}
	else{
	    double m1 = 1.0 * Median.get(0);
	    double m2 = 1.0 * Median.get(0);
	    return (m1 + m2)/2.0;
	}
    }
    public String toString(){
	return Smaller.arrayToString() + " " +  Median.toString() + " " + Larger.arrayToString();
    }
}
