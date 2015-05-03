
import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;
    private boolean hasLeft;
    private boolean hasRight;

    public BSTreeNode( T d ) {
	data = d;
	left = right = null;
	hasLeft = hasRight = false;
    }
    
    public int compareTo(BSTreeNode<T> Node){
	return data.compareTo(Node.getData());
    }
    
    public T getData() {
	return data;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }

    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }
    public String toString(){
	return "" + data;
    }
    public boolean hasLeft(){
	return hasLeft;
    }
    public boolean hasRight(){
	return hasRight;
    }
}
