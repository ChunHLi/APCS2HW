public class LNode<T>{
    private LNode<T> cdr;
    private T data;
    public LNode(){
    }
    public LNode(T Data){
	setData(Data);
    }
    public LNode(T Data, LNode<T> CDR){
	setData(Data);
	setCDR(CDR);
    }
    public T getData(){
	return data;
    }
    public void setData(T Data){
	data = Data;
    }
    public LNode<T> getCDR(){
	return cdr;
    }
    public void setCDR(LNode<T> CDR){
	cdr = CDR;
    }
    public String toString(LNode<T> Node){
	return "" + data;
    }
}