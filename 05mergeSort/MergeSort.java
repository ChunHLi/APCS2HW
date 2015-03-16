import java.util.Arrays;

public class MergeSort{
    public static void main(String[]args){
	int[] A = {9,5,2,4,7,8,1,0,3,6};
	//System.out.println(Arrays.toString(mergeSort(A)));
	mergeSort(A);
	System.out.println(Arrays.toString(A));
    }
    public static String name(){
	return "li.shawn";
    }
    public static void mergeSort(int[] a){
	int[] b = mergeSortHelper(a);
	int counter = 0;
	while (counter < a.length){
	    a[counter] = b[counter];
	    counter += 1;
	}
    }
    public static int[] mergeSortHelper(int[] a){
	if (a.length <= 1){
	    return a;
	}
	else{
	    int[] b = Arrays.copyOfRange(a, 0, a.length/2);
	    int[] c = Arrays.copyOfRange(a, a.length/2, a.length);
	    return merge(mergeSortHelper(b),mergeSortHelper(c));
	}

    }
    public static int[] merge(int[] a, int[]b){
	if (a.length == 0){
	    return b;
	}
	if (b.length == 0){
	    return a;
	}
	int [] c = new int[a.length + b.length];
	int counter = 0;
	int counterA = 0;
	int counterB = 0;
	while (counter < a.length + b.length && counterA < a.length && counterB < b.length){
	    if (a[counterA] < b[counterB]){
		c[counter] = a[counterA];
		counterA += 1;
	    }
	    else{
		c[counter] = b[counterB];
		counterB += 1;
	    }
	    counter += 1;
	}
	while (counterA < a.length){
	    c[counter] = a[counterA];
	    counterA += 1;
	    counter += 1;
 	}
	while (counterB < b.length){
	    c[counter] = b[counterB];
	    counterB += 1;
	    counter += 1;
	}
	return c;
    }
    
}
