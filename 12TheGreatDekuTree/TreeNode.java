import java.io.*;
import java.util.*;

public class TreeNode<E>{
    private TreeNode<E> leftLeaf;
    private TreeNode<E> rightLeaf;
    private boolean hasLeft;
    private boolean hasRight;
    private E data;

    public TreeNode(E Data){
	data = Data;
	hasLeft = false;
	hasRight = false;
	leftLeaf = null;
	rightLeaf = null;
    }

    public TreeNode(E Data, TreeNode Left, TreeNode Right){
	data = Data;
	hasLeft = false;
	hasRight = false;
	leftLeaf = Left;
	rightLeaf = Right;
    }

    public E getData(){
	return data;
    }
    public void setData(E Data){
	data = Data;
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
    public boolean hasLeft(){
	return hasLeft;
    }
    public boolean hasRight(){
	return hasRight;
    }
}