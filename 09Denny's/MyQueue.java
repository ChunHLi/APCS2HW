import java.util.*;

public class MyQueue<T>{
    MyLinkedList<T> Queue;
    
    public MyQueue(){
	Queue = new MyLinkedList<T>();
    }
    public void enqueue(T nextOnLine){
	if (nextOnLine == null){
	    throw new NullPointerException();
	}
	Queue.add(nextOnLine);
    }
    public void dequeue(){
	if (Queue.size() > 0){
	    Queue.remove(0);
	}
	else{
	    throw new NoSuchElementException();
	}
    }
}
