public class MyDeque<T>{
    private T[] Queue;
    private int head;
    private int tail;
    public static void main(String[]args){
	MyDeque A = new MyDeque(0);
	A.addFirst(5);
	A.addLast(3);
	System.out.println(A.getLast());
	System.out.println(A.getFirst());
	A.addFirst(4);
	A.addFirst(7);
	System.out.println(A.getFirst());
	System.out.println(A.removeFirst());
	System.out.println(A.removeFirst());
	System.out.println(A.getFirst());
	A.addFirst(6);
	System.out.println(A.getFirst());
    }
    public MyDeque(){
    }
    public MyDeque(int size){
	Queue = (T[])new Object[size];
	tail = 0;
	if (size > 1){
	    tail = size - 1;
	}
	head = 0;
    }
    public void addFirst(T newHead){
	if (Queue.length == 0){
	    resize(Queue);
	    Queue[0] = newHead;
	}
	else{
	    resize(Queue);
	    Queue[Queue.length - 1] = newHead;
	    head = Queue.length - 1;
	    tail = Queue.length - 2;
	}
	
    }
    public void addLast(T newTail){
	if (Queue.length == 0){
	    resize(Queue);
	    Queue[0] = newTail;
	}
	else{
	    resize(Queue);
	    Queue[Queue.length - 1] = newTail;
	    head = 0;
	    tail = Queue.length - 1;
	}
    }
    public T removeFirst(){
    	T returnT = getFirst();
    	if (head == Queue.length - 1){
    	    head = 0;
    	}
    	else{
    	    head += 1;
    	}
	resize2(Queue);
	head = 0;
	tail = Queue.length - 1;
	return returnT;
    }
    //public T removeLast(){
    //}
    public T getFirst(){
	return Queue[head];
    }
    public T getLast(){
	return Queue[tail];
    }
    public void resize(T[] queue){
	T[] newQueue;
	int length;
	if (head == 0){
	    newQueue = (T[])new Object[(Queue.length + 1)];
	    length = Queue.length;
	}
	else{
	    newQueue = (T[])new Object[(Queue.length - head) + tail + 1 ];
	    length = (Queue.length - head) + tail;
	}
	if (queue.length == 0){
	}
	else{
	    int counter = 0;
	    while (head + counter < Queue.length){
		newQueue[counter] = Queue[head + counter];
		counter += 1;	
	    }
	    int counter2 = 0;
	    while (tail - counter2 >= 0){
		newQueue[counter] = Queue[counter2];
		counter += 1;
		counter2 += 1;
		head = 0;
		tail = Queue.length - 2;
	    }
	}
	Queue = newQueue;
    }
    public void resize2(T[] queue){
	T[] newQueue;
	int counter = 0;
	newQueue = (T[])new Object[(Queue.length - 1)];
	if (queue.length == 0){
	}
	else if (tail == Queue.length - 2){
	    while (head + counter <= tail){
		newQueue[counter] = Queue[counter];
		counter += 1;
	    }
	}
	else{
	    while (head + counter < Queue.length){
		newQueue[counter] = Queue[head + counter];
		counter += 1;	
	    }
	    int counter2 = 0;
	    while (tail - counter2 >= 0){
		newQueue[counter] = Queue[counter2];
		counter += 1;
		counter2 += 1;
		head = 0;
		tail = Queue.length - 2;
	    }
	
	}
	Queue = newQueue;
    }
}
