import java.util.*;

public class MyPriorityQueue<T>{
    ArrayDeque<T> PriorityQueue;
    LinkedList<Integer> PriorityList;
    
    public MyPriorityQueue(){
	PriorityQueue = new ArrayDeque<T>();
	PriorityList =  new LinkedList<Integer>();
    }

    public void add(T t, int n){
	LinkedList<T> PriorityQueueList = new LinkedList<T>(PriorityQueue);
	if (PriorityQueueList.size() == 0){
	    PriorityQueueList.add(t);
	    PriorityList.add(n);
	}
	else{
	    int counter = 0;
	    while (counter <= PriorityQueueList.size()){
		if (counter == PriorityQueueList.size()){
		    PriorityQueueList.add(t);
		    PriorityList.add(n);
		    break;
		}
		if (n > PriorityList.get(counter)){
		    PriorityQueueList.add(counter,t);
		    PriorityList.add(counter,n);
		    break;
		}
		counter += 1;
	    }
	}
	PriorityQueue = new ArrayDeque<T>(PriorityQueueList);
    }
    
    public T removeSmallest(){
	PriorityList.removeFirst();
	return PriorityQueue.removeFirst();
    }
}
