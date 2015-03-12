public class MyLinkedList{
    LNode start;
    LNode end;
    int now = 0;
    int Size;

    public static void main(String[]args){
	LNode NodeA = new LNode(5);
	LNode NodeB = new LNode(6, NodeA);
	LNode NodeC = new LNode(7, NodeB);
	MyLinkedList A = new MyLinkedList(NodeC);
	System.out.println(A.toString());
	System.out.println(A.get(2));
	//System.out.println(A.get(4));
	A.set(2,10);
	System.out.println(A.toString());
    }
    public MyLinkedList(){
    }
    public MyLinkedList(LNode N){
	start = N;
	end = N.getCDR();
	Size = 1;
	LNode Current = N;
	while (Current.getCDR() != null){
	    Size += 1;
	    Current = Current.getCDR();
	}
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
	now = 0;
    }
    public void add(int data){
	start.setCDR(end);
	end.setData(data);
	Size += 1;
    }

    public void add(int index, int data){
    }
    public void remove(int index){
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
