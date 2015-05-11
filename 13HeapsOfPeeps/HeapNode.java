public class HeapNode<T>{
    
    private T data;
    private int index;
    
    public HeapNode(){
    }

    public HeapNode(int Index, T Data){
	data = Data;
	index = Index;
    }

    public T getData(){
	return data;
    }
    
    public void setData(T Data){
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
