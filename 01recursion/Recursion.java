public class Recursion{
    public String name(){
	return "Li,Shawn";
    }
    public int fact(int n){
	int product;
	if (n < 0){
	    throw new IllegalArgumentException("n cannot be negative");
	}
	if (n == 1 || n == 0){
	    return 1;
	}
	product = n * fact(n - 1);
	return product;
    }
    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException("n cannot be negative");
	}
	if (n <= 1){
	    return n;
	}
	else{
	    return fib(n - 1) + fib(n - 2);
	}
    }
    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException("You cannot take the sqrt of a negative number");
	}
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
