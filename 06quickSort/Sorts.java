import java.util.Random;
import java.util.Arrays;

public class Sorts{
    public static void main(String[]args){
	int[] A = {0,13,7,21,69,42,420,100};
	//System.out.println(partition(A,4,5));
	//System.out.println(Arrays.toString(A));
        //System.out.println(quickSelect(A,2));
	quickSort(A);
	System.out.println(Arrays.toString(A));
    }
    public static void quickSort(int[] a){
	quickSort(a, 0, a.length - 1);
    }
    public static void quickSort(int[] a, int s, int e){
	if (e - s >= 0){
	    int i = partition(a, s, e);
	    quickSort(a, s, i - 1);
	    quickSort(a, i + 1, e);
	}
    }
    public static int quickSelect(int[] a, int n){
	return quickSelect(a,0,a.length - 1,n - 1);
    }
    public static int quickSelect(int[] a, int s, int e, int n){
	System.out.println(Arrays.toString(a));
	if (s <= e){
	    int i = partition(a, s, e);
	    if (i == n){
		return a[n];
	    }
	    if (i > n){
		return quickSelect(a, s,i - 1, n);
	    }
	    else{
		return quickSelect(a, i + 1, e, n);
	    }
	}
	else{
	    return -1;
	}
    }
    public static int partition(int[] a,int s, int e){
	int[] b = new int[a.length];
	int counter = 0;
	while (counter < b.length){
	    if (counter < s || counter > e){
		b[counter] = a[counter];
	    }
	    counter += 1;
	}
	Random r = new Random();
	int i = r.nextInt(e-s+1) + s;
	counter = 0;
	int counterS = 0;
	int counterE = 0;
	while (counterS + s != e - counterE){
	    if (a[counter + s] < a[i]){
		b[counterS + s] = a[counter + s];
		counterS += 1;
	    }
	    else if (a[counter +s] > a[i]){
		b[e - counterE] = a[counter + s];
		counterE += 1;
	    }
	    counter += 1;
	}
	b[counterS + s] = a[i];
	int returnInt = counterS + s;
	while (s <= e){
	    a[s] = b[s];
	    s += 1;
	}
	return returnInt;
    }
}
