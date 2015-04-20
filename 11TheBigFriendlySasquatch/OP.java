import java.util.*;

public class OP{

    int row;
    int col;
    int distanceTraveled;
    int distanceFromEnd;
    OP previous;

    public OP(int Row, int Col, int Distance){
	row = Row;
	col = Col;
	distanceTraveled = Distance;
	previous = null;
    }

    public OP(int Row, int Col, int Distance, OP Previous){
	row = Row;
	col = Col;
	distanceTraveled = Distance;
	previous = Previous;
    }

    public OP(int Row, int Col, int DistanceTraveled, int DistanceFromEnd, OP Previous){
	row = Row;
	col = Col;
	distanceTraveled = DistanceTraveled;
	distanceFromEnd = DistanceFromEnd;
	previous = Previous;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public int getDistance(){
	return distanceTraveled;
    }
    
    public int getDistanceFromEnd(){
	return distanceFromEnd;
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
	distanceTraveled = Distance;
    }

    public void setDistanceFromEnd(int Distance){
	distanceFromEnd = Distance;
    }
    
    public void setPrevious(OP Previous){
	previous = Previous;
    }
}
