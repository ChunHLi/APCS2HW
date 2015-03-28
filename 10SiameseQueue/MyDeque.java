import java.util.*;

public class MyDeque<T>{
    private T[] Queue;
    private int head;
    private int tail;
    private int size;
    public MyDeque(){
	Queue = (T[])new Object[10];
	head = 0;
	tail = 0;
	size = 0;
    }
    public void addFirst(Object newHead){
	if (size == 0){
	    head = 0;
	    tail = 0;
	    Queue[0] = (T)newHead;
	}
	else{
	    resize();
	    head = tail + 1;
	    Queue[head] = (T)newHead;
	}
	size += 1;
    }
    public void addLast(Object newTail){
	if (size == 0){
	    head = 0;
	    tail = 0;
	    Queue[0] = (T)newTail;
	}
	else{
	    resize();
	    tail += 1;
	    Queue[tail] = (T)newTail; 
	}
	size += 1;
    }
    public T removeFirst(){
	if (size <= 0){
	    throw new NoSuchElementException();
	}
        T returnT = Queue[head];
	Queue[head] = null;
	if (head > tail){
	    head = 0;
	}
	else{
	    head += 1;
	}
	size -= 1;
	return returnT;
    }
    public T removeLast(){
	if (size <= 0){
	    throw new NoSuchElementException();
	}
	T returnT = Queue[tail];
	Queue[tail] = null;
	tail -= 1;
	size -= 1;
	return returnT;
    }
    public T getFirst(){
	if (size <= 0){
	    throw new NoSuchElementException();
	}
	return Queue[head];
    }
    public T getLast(){
	if (size <= 0){
	    throw new NoSuchElementException();
	}
	return Queue[tail];
    }
    public void resize(){
	if (size == Queue.length || head > tail){
	    T[] newQueue = (T[])new Object[size*2];
	    int counter = 0;
	    int counter2 = 0;
	    while (head + counter <= size - 1){
		newQueue[counter] = Queue[head + counter];
		counter += 1;
	    }
	    while (counter2 <= tail){
		newQueue[counter] = Queue[counter2];
		counter += 1;
		counter2 += 1;
	    }
	    head = 0;
	    tail = size - 1;
	    Queue = newQueue;
	}
    }
    public void desize(){
	
    }
    public int size(){
	return size;
    }
}
