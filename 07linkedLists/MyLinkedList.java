public class MyLinkedList{
    LNode start;
    LNode end;
    int now = 0;
    int Size;
    public static void main(String[]args){
    }
    public MyLinkedList(){
    }
    public MyLinkedList(LNode N){
	start = N;
	Size = 1;
	LNode Current = N;
	while (Current.getCDR() != null){
	    Size += 1;
	    Current = Current.getCDR();
	}
	end = Current;
    }
    public int get(int index){
	if (index >= Size){
	    throw new IndexOutOfBoundsException();
	}
	int Data = -1;
	LNode Current = start;
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
    public void set(int index, int data){
	if (index >= Size){
	    throw new IndexOutOfBoundsException();
	}
	LNode Current = start;
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
    public boolean add(int data){
	LNode NNode = new LNode(data);
	end.setCDR(NNode);
	end = NNode;
	Size += 1;
	return true;
    }
    public boolean add(int index, int data){
    	if (index > Size){
    	    throw new IndexOutOfBoundsException();
    	}
    	else if (index == Size){
	    add(data);
    	}
	else if (index == 0){
	    LNode NNode = new LNode(data,start);
	    start = NNode;
	    Size += 1;
	    now = 0;
	}
    	else{
    	    LNode Current = start;
    	    while (now < index - 1){
    		Current = Current.getCDR();
    		now +=1;
    	    }
	    LNode NNode = new LNode(data);
	    LNode Attach = Current.getCDR();
	    Current.setCDR(NNode);
	    NNode.setCDR(Attach);
	    Size += 1;
	    now = 0;

    	}
	return true;
	
    }
    public int remove(int index){
	if (index >= Size){
    	    throw new IndexOutOfBoundsException();
    	}
	else{
	    int returnint;
	    LNode Current = start;
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
		    LNode Attach = Current.getCDR().getCDR();
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
    public int indexOf(int data){
	LNode Current = start;
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
	LNode current = start;
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
