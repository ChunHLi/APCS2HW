public class HeapNode{
    
    private int data;
    private int index;
    
    public HeapNode(){
	data = 0;
	index = -1;
    }

    public HeapNode(int Index, int Data){
	data = Data;
	index = Index;
    }

    public int getData(){
	return data;
    }
    
    public void setData(int Data){
	data = Data;
    }
    
    public int getIndex(){
	return index;
    }

    public int getLeftIndex(){
	return index * 2;
    }

    public int getRightIndex(){
	return index * 2 + 1;
    }

    public int getParentIndex(){
	return index/2;
    }
}
