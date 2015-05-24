
public class fibonacci_sequence {

	//0 1 1 2 3 5
	
	public static int fibo_rec (int n) 
	{
		if (n==0) 
		{
			return 0;
		}
		
		else if (n==1) 
		{
			return 1;
		}
		
		else if (n > 1) 
		{
			return fibo_rec (n-1) + fibo_rec (n-2);
		}
		
		else 
		{
			return -1;
		}
			
	}
	
	public int fibo_iter (int n) 
	{
		return 0;
	}
	
	public static void main(String[] args) {
		int n = 2;
		int result = fibo_rec (n);
		System.out.println(n + "-th term of Fibonacci Sequence is - " + result);
	}

}
