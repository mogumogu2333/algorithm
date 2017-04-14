package math;

public class M50_Pow {

	public double myPow(double x, int n) {
        if(n<0){
        	return power(1.0/x, -n);
        }
        else return power(x,n);
    }
    
    private double power(double x, int n){
        if(n==0)return 1;
        if(n==1)return x;
        double v = power(x,n/2);
        if(n%2==0){
            return v*v;
        }
        else{
            return v*v*x;
        }
    }

	
	
	
	public static void main(String[] args) {
		double x = 2.0;
		int n = Integer.MIN_VALUE;
		
		M50_Pow sol = new M50_Pow();
		System.out.println(sol.myPow(x, n));
	}

}
