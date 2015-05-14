import java.util.*;

public class MyHeap{
    
    HeapNode[] ArrayHeap;
    boolean isMax;

    public MyHeap(){
	ArrayHeap = new HeapNode[1];
	ArrayHeap[0] = new HeapNode();
	isMax = true;
    }
    
    public MyHeap(boolean IsMax){
	ArrayHeap = new HeapNode[1];
	ArrayHeap[0] = new HeapNode();
	isMax = IsMax;
    }
    
    public static void main(String[]args){
	MyHeap A = new MyHeap(false);
	A.add(4);
	A.add(7);
	A.add(3);
	A.add(2);
	A.add(5);
	A.remove();
	System.out.println(A.arrayToString());
	//System.out.println(A.size());
    }
    
    public void add(int Node){
	if (size() >= ArrayHeap.length - 1){
	    resize();
	}
	sizeUp();
	ArrayHeap[size()] = new HeapNode(size(),Node);
	addHelper(size());
	System.out.println("\n");
    }
    
    public void addHelper(int index){
	if (index == 1){
	}
	else if (compareTo(ArrayHeap[index],ArrayHeap[ArrayHeap[index].getParentIndex()])){
	    int tmp = ArrayHeap[index].getData();
	    ArrayHeap[index].setData(ArrayHeap[ArrayHeap[index].getParentIndex()].getData());
	    ArrayHeap[ArrayHeap[index].getParentIndex()].setData(tmp);
	    addHelper(ArrayHeap[index].getParentIndex());
	}
	
    }

    public int remove(){
	HeapNode tmp = new HeapNode(1,ArrayHeap[size()].getData());
	ArrayHeap[size()] = new HeapNode();
	ArrayHeap[1] = tmp;
	sizeDown();
	removeHelper(1);
	return tmp.getData();
    }

    public void removeHelper(int index){
	if (index * 2 > size()){
	}
	else{
	    if (index * 2 == size()){
		if (compareTo(ArrayHeap[ArrayHeap[index].getLeftIndex()],ArrayHeap[index])){
			int tmp = ArrayHeap[index].getData();
			ArrayHeap[index].setData(ArrayHeap[ArrayHeap[index].getLeftIndex()].getData());
			ArrayHeap[ArrayHeap[index].getLeftIndex()].setData(tmp);
			removeHelper(ArrayHeap[index].getLeftIndex());
		    }
	    }
	    else if (index * 2 + 1 <= size()){
		System.out.println(index);
		System.out.println(ArrayHeap[index].getLeftIndex());
		if ((compareTo(ArrayHeap[ArrayHeap[index].getLeftIndex()],ArrayHeap[index])) && compareTo(ArrayHeap[ArrayHeap[index].getLeftIndex()],ArrayHeap[ArrayHeap[index].getRightIndex()])){
		    int tmp = ArrayHeap[index].getData();
		    ArrayHeap[index].setData(ArrayHeap[ArrayHeap[index].getLeftIndex()].getData());
		    ArrayHeap[ArrayHeap[index].getLeftIndex()].setData(tmp);
		    removeHelper(ArrayHeap[index].getLeftIndex());
		}
		else{
		    if (compareTo(ArrayHeap[ArrayHeap[index].getRightIndex()],ArrayHeap[index])){
			int tmp = ArrayHeap[index].getData();
			ArrayHeap[index].setData(ArrayHeap[ArrayHeap[index].getRightIndex()].getData());
			ArrayHeap[ArrayHeap[index].getRightIndex()].setData(tmp);
			removeHelper(ArrayHeap[index].getRightIndex());
		    }
		}
	    }
	}
    }
		    
		    	    
	   
    
    public void sizeUp(){
	ArrayHeap[0].setData(size() + 1);
    }
	
    public void sizeDown(){
	ArrayHeap[0].setData(size() - 1);
    }

    public int size(){
	if (ArrayHeap[0] == null){
	    return 0;
	}
	return ArrayHeap[0].getData();
    }
    
    public void resize(){
	HeapNode[] newHeap = new HeapNode[ArrayHeap.length*2];
	int counter = 0;
	while (counter < ArrayHeap.length){
	    newHeap[counter] = ArrayHeap[counter];
	    counter += 1;
	}
	ArrayHeap = newHeap;
    }
    
    public String arrayToString(){
	String Str = "[";
	int counter = 1;
	while (counter < size()){
	    Str += " " + ArrayHeap[counter].getData() + ",";
	    counter += 1;
	}
	Str += " " + ArrayHeap[counter].getData() + " ]";
	return Str;
    }
    public boolean compareTo(HeapNode A, HeapNode B){
	int valueOf = A.getData() - B.getData();
	boolean greater = valueOf >= 0;
	return isMax && greater || !(isMax || greater);
    }
}
