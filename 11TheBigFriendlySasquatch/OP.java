import java.util.*;

public class OP{

    int row;
    int col;
    int distance;
    OP previous;

    public OP(int Row, int Col, int Distance){
	row = Row;
	col = Col;
	distance = Distance;
	previous = null;
    }

    public OP(int Row, int Col, int Distance, OP Previous){
	row = Row;
	col = Col;
	distance = Distance;
	previous = Previous;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public int getDistance(){
	return distance;
    }
    
    public OP getPrevious(){
	return previous;
    }

    public void setRow(int Row){
	row = Row;
    }

    public void setCol(int Col){
	col = Col;
    }
    
    public void setDistance(int Distance){
	distance = Distance;
    }
    
    public void setPrevious(OP Previous){
	previous = Previous;
    }
}
