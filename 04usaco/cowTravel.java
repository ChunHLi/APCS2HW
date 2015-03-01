public class cowTravel{

    public int N;
    public int M;
    public int T;
    public char[][] map;
    public int Ra;
    public int Ca;
    public int Rb;
    public int Cb;
    public int Z;

    public cowTravel(int a, int b, int c, char[][] d, int e, int f, int g, int h){N = a;
	M = b;
	T = c;
	map = d;
	Ra = e;
	Ca = f;
	Rb = g;
	Cb = h;
	Z = 0;}

    public void start(){
	run(Ra, Ca, T);}
    
    public boolean run(int a, int b, int c){
	if(b >= map.length || a >= map[0].length || a<0 || b<0 || map[a][b] == '*'){
	    return false;}
	if(c == 0 && a == Rb && b == Cb){
	    Z+=1;
	    return true;}
	if(c == 0){
	    return false;}
	run(a+1,b,c-1);
	run(a-1,b,c-1);
	run(a,b+1,c-1);
	run(a,b-1,c-1);
	return false;}

    public static void main(String[] args){
	char[][] D = {{'.','.','.','*','.'},
	    {'.','.','.','*','.'},
		      {'.','.','.','.','.'},
		      {'.','.','.','.','.'}};
	cowTravel a = new cowTravel(4, 5, 6, D, 1,3,1,5);
	a.start();
	System.out.println(a.Z);}}
	