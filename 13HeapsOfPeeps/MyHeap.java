import java.util.*;

public class MyHeap{
    
    HeapNode[] ArrayHeap;
    boolean isMax;

    public MyHeap(){
	ArrayHeap = new HeapNode[1];
	isMax = true;
    }
    
    public MyHeap(boolean IsMax){
	ArrayHeap = new HeapNode[1];
	isMax = IsMax;
    }
    
    public void add(){
    }

    //public int remove(){
    //}
    
    public void sizeUp(){
	ArrayHeap[0].setData(ArrayHeap[0].getData() + 1);
    }

    public int size(){
	return ArrayHeap[0].getData();
    }
    
    public void resize(){
    }
    
    //public String toString(){
    //}
    public boolean compareTo(HeapNode A, HeapNode B){
	int valueOf = A.getData() - B.getData();
	boolean greater = valueOf >= 0;
	return isMax && greater || !(isMax || greater);
    }
}
