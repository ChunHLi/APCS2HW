public class MyDeue{
    private T[] Queue;
    private int head;
    private int tail;
    public MyDeque(){
    }
    public MyDeque(int size){
	Queue = new T[size];
	head = 0;
	tail = size - 1;
    }
    public void addFirst(T newHead){
	if (head == tail){
	    Queue[head] = newHead;
	}
	else if ((head == 0 && tail == Queue.length - 1) || head - tail == 1){
	    resize(Queue);
	    Queue[Queue.length - 1] = newHead;
	    head = Queue.length - 1;
	    tail = Queue.length - 2;
	}
	    
    }
    public void addLast(T lastHead){
    }
    public T removeFirst(){
    }
    public T removeLast(){
    }
    public void resize(T[] queue){
	T[] newQueue = new T[Queue.length + 1];
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
	}
	Queue = newQueue;
    }
    
}