import java.util.*;

public class MyStacks<E>{
    private MyLinkedList<E> plate;
    private E topLayer;
    
    public MyStacks(){
	plate = new MyLinkedList<E>();
    }
    
    public boolean empty(){
        return plate.size() == 0;
    }
    
    public E peek(){
	return plate.get(0);
    }
    
    public E pop(){
	return plate.remove(0);
    }
    
    public E push(E moreLayers){
	//if (empty()){
	//    plate.add(moreLayers);
	//}
	//else{
	plate.add(0,moreLayers);
	//}
	topLayer = moreLayers;
	return moreLayers;
    }

}
