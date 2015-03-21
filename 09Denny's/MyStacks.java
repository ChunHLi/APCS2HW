import java.util.*;

public class MyStacks<E>{
    private LinkedList<E> plate;
    private E topLayer;
    
    public MyStacks(){
	plate = new LinkedList<E>();
    }
    
    public boolean empty(){
        return plate.size() == 0;
    }
    
    public E peek(){
	return plate.getFirst();
    }
    
    public E pop(){
	return plate.removeFirst();
    }
    
    public E push(E moreLayers){
	//if (empty()){
	//    plate.add(moreLayers);
	//}
	//else{
	plate.addFirst(moreLayers);
	//}
	topLayer = moreLayers;
	return moreLayers;
    }

}
