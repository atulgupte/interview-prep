
public class rotated_binary_search {

	static void rotated_binary_search(int A[], int key) {
		  int L = 0;
		  int R = A.length-1;
		 
		  while (L <= R) {
		    // Avoid overflow, same as M=(L+R)/2
		    int M = L + ((R - L) / 2);
		    if (A[M] == key) {
		    	//return M;
		    	System.out.println("Element found! Number is = " + A[M] + " and Index is = " + M);
		    	return;
		    }
		    	
		    // the bottom half is sorted
		    if (A[L] <= A[M]) {
		      if (A[L] <= key && key < A[M])
		        R = M - 1;
		      else
		        L = M + 1;
		    }
		    // the upper half is sorted
		    else {
		      if (A[M] < key && key <= A[R])
		        L = M + 1;
		      else 
		        R = M - 1;
		    }
		  }
		  System.out.println("Error: Element not found!");
		  return;
		}
	
	public static void main(String[] args) {
		int a1[] = {4,5,6,7,1,2,3};
		int a2[] = {5,6,1,2,3,4};
		int a3[] = {1,2,3,4,5,6};
		int a4[] = {3,4,5,6,7,8,9,1,2};
		int a5[] = {1,2,3};
		int a6[] = {2,1};
		rotated_binary_search(a1, 6);
		rotated_binary_search(a2, 6);
		rotated_binary_search(a3, 6);
		rotated_binary_search(a4, 6);
		rotated_binary_search(a5, 6);
		rotated_binary_search(a6, 1);
	}

}
