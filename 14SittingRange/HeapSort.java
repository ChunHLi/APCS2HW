public class HeapSort{
    private static int Size;
    
    public static void heapSort(int[] Array){       
	int counter = Size;
	heapify(Array);
	while (counter > 0){
            swap(Array, 0, counter);
            maxheap(Array, 0);
	    Size -= 1;
	    counter -= 1;
        }	
    }     

    public static void heapify(int[] Array){
        Size = Array.length - 1;
	int counter = Size/2;
	while (counter >= 0){
            maxheap(Array, counter); 
	    counter -= 1;
	}
    }
    
    public static void maxheap(int[] Array, int Index){ 
        int left = Index * 2;
        int right = Index * 2 + 1;
        int Largest = Index;
        if (left <= Size && Array[left] > Array[Index]){
            Largest = left;
	}
        if (right <= Size && Array[right] > Array[Largest]){    
            Largest = right;
	}
        if (Largest != Index){
            swap(Array, Index, Largest);
            maxheap(Array, Largest);
        }
    }    

    public static void swap(int[] Array, int firstIndex, int secondIndex){
        int temp = Array[firstIndex];
        Array[firstIndex] = Array[secondIndex];
        Array[secondIndex] = temp; 
    }    
}
