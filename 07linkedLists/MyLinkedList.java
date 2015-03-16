public class MyLinkedList<T>{
    LNode<T> start;
    LNode<T> end;
    int now = 0;
    int Size;
    public static void main(String[]args){
	
    }
    public MyLinkedList(){
    }
    public MyLinkedList(LNode<T> N){
	start = N;
	Size = 1;
	LNode<T> Current = N;
	while (Current.getCDR() != null){
	    Size += 1;
	    Current = Current.getCDR();
	}
	end = Current;
    }
    public T get(int index){
	if (index >= Size){
	    throw new IndexOutOfBoundsException();
	}
	T Data = null;
	LNode<T> Current = start;
	while (now < Size){
	    if (now == index){
		Data = Current.getData();
	    }
	    now += 1;
	    Current = Current.getCDR();
	}
	now = 0;
	return Data;
    }
    public void set(int index, T data){
	if (index >= Size){
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> Current = start;
	while (now < Size){
	    if (now == index){
		Current.setData(data);
	    }
	    now +=1;
	    Current = Current.getCDR();
	}
	end = Current;
	now = 0;
    }
    public boolean add(T data){
	LNode<T> NNode = new LNode<T>(data);
	end.setCDR(NNode);
	end = NNode;
	Size += 1;
	return true;
    }
    public boolean add(int index, T data){
    	if (index > Size){
    	    throw new IndexOutOfBoundsException();
    	}
    	else if (index == Size){
	    add(data);
    	}
	else if (index == 0){
	    LNode<T> NNode = new LNode<T>(data,start);
	    start = NNode;
	    Size += 1;
	    now = 0;
	}
    	else{
    	    LNode<T> Current = start;
    	    while (now < index - 1){
    		Current = Current.getCDR();
    		now +=1;
    	    }
	    LNode<T> NNode = new LNode<T>(data);
	    LNode<T> Attach = Current.getCDR();
	    Current.setCDR(NNode);
	    NNode.setCDR(Attach);
	    Size += 1;
	    now = 0;

    	}
	return true;
	
    }
    public T remove(int index){
	if (index >= Size){
    	    throw new IndexOutOfBoundsException();
    	}
	else{
	    T returnint = null;
	    LNode<T> Current = start;
	    if (index == 0){
		returnint = start.getData();
		start = Current.getCDR();
	    }
	    else{
		while (now < index - 1){
		    Current = Current.getCDR();
		    now +=1;
		}
		if (index == Size - 1){
		    returnint = Current.getCDR().getData();
		    Current.setCDR(null);
		    end = Current;
		}
		else{
		    LNode<T> Attach = Current.getCDR().getCDR();
		    returnint = Current.getCDR().getData();
		    Current.setCDR(Attach);
		}
	    }
	    now = 0;
	    Size -= 1;
	    return returnint;
	}
    }
    public int size(){
	return Size;
    }
    public int indexOf(T data){
	LNode<T> Current = start;
	int index = -1;
	while (now < Size){
	    if (Current.getData() == data){
		index = now;
	    }
	    Current = Current.getCDR();
	    now += 1;
	}
	now = 0;
	return index;
    }
    public String toString(){
	String List = "[ ";
	LNode<T> current = start;
	while (now < Size - 1){
	    List += current.getData() + ", ";
	    current = current.getCDR();
	    now += 1;
	}
	List += current.getData() + " ]";
	now = 0;
	return List;
    }
}
