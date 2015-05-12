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
    
    public void add(int Node){
	if (size() >= ArrayHeap.length - 1){
	    resize();
	}
	ArrayHeap[ArrayHeap[0].getData()] = new HeapNode(ArrayHeap[0].getData(),Node);
	sizeUp();
	addHelper(size());
    }
    
    public void addHelper(int index){
	if (compareTo(ArrayHeap[index],ArrayHeap[ArrayHeap[index].getParentIndex()])){
	    int tmp = ArrayHeap[index].getData();
	    ArrayHeap[index].setData(ArrayHeap[ArrayHeap[index].getParentIndex()].getData());
	    ArrayHeap[ArrayHeap[index].getParentIndex()].setData(tmp);
	    addHelper(ArrayHeap[index].getParentIndex());
	}
	
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
	HeapNode[] newHeap = new HeapNode[ArrayHeap.length * 2];
	int counter = 0;
	while (counter < ArrayHeap.length){
	    newHeap[counter] = ArrayHeap[counter];
	    counter += 1;
	}
	ArrayHeap = newHeap;
    }
    
    //public String toString(){
    //}
    public boolean compareTo(HeapNode A, HeapNode B){
	int valueOf = A.getData() - B.getData();
	boolean greater = valueOf >= 0;
	return isMax && greater || !(isMax || greater);
    }
}

