public class Recursion{
    public String name(){
	return "Li,Shawn";
    }
    public int fact(int n){
	int product;
	if (n == 1){
	    return 1;
	}
	product = n * fact(n - 1);
	return product;
    }
    public int fib(int n){
	if (n <= 1){
	    return n;
	}
	else{
	    return fib(n - 1) + fib(n - 2);
	}
    }
    public double sqrt(double n){
	return sqrtAlgorithm(1.0,n);
    }
    public double sqrtAlgorithm(double guess,double n){
	double tolerance = n / 1000000;
	if (Math.abs(n/guess - guess) <= tolerance){
	    return guess;
	}
	guess = sqrtAlgorithm(( n / guess + guess) / 2,n);    
	return guess;
    }
}
