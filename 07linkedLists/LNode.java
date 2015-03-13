public class LNode{
    private LNode cdr;
    private int data;
    public LNode(){
    }
    public LNode(int Data){
	setData(Data);
    }
    public LNode(int Data, LNode CDR){
	setData(Data);
	setCDR(CDR);
    }
    public int getData(){
	return data;
    }
    public void setData(int Data){
	data = Data;
    }
    public LNode getCDR(){
	return cdr;
    }
    public void setCDR(LNode CDR){
	cdr = CDR;
    }
    public String toString(LNode Node){
	return "" + data;
    }
}