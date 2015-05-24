
public class find_sqrt {

	public static double sqrt(double number, double epsilon) {
	
		double left = 0.0;
		double right = number;
		double mid = 0.0;
		
		while (left + epsilon < right) {
			mid = (left + right)/2.0;
			if (mid*mid > number) {
				right = mid;
			} else {
				left = mid;
			}
		}
		
		return left;
	}
	
	public static void main(String[] args) {
		double number = 49.0;
		double epsilon = 0.000000001;
		double result = sqrt(number, epsilon);
		System.out.println("Square root of " + number + " is: " + result);
	}

}
