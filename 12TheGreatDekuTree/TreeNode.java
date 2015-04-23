import java.io.*;
import java.util.*;

public class TreeNode<E>{
    private TreeNode<E> leftLeaf;
    private TreeNode<E> rightLeaf;
    private TreeNode<E> next;
    private boolean hasLeft;
    private boolean hasRight;
    private E data;

    public TreeNode(E Data){
	    next = null;
	    data = Data;
	
    }

    public TreeNode(E Data, TreeNode Next){
	    next = Next;
	    data = Data;
    }

    public E getData(){
	    return data;
    }
    public void setData(E Data){
	    data = Data;
    }

    public TreeNode<E> getNext(){
	    return next;
    }

    public void setNext(TreeNode<E> Next){
	    next = Next;
    }

    public TreeNode<E> getLeft(){
	    return leftLeaf;
    }

    public void setLeft(TreeNode<E> Node){
	    hasLeft = true;
	    leftLeaf = Node;
    }
    
    public TreeNode<E> getRight(){
	    return rightLeaf;
    }
    
    public void setRight(TreeNode<E> Node){
	    hasRight = true;
	    rightLeaf = Node;
    }

    public String toString(){
	    return "" + data;
    }
}
