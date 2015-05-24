import java.util.HashMap;


public class find_pair_that_sums_to_n {

	//ATUL: Need to re-do this using HashSet or some better error checking so it does not print all pairs twice
	
	public static void find_pairs_n_solution(int[] array, int n) {
		if (array == null) {
			System.out.println("ERROR: Array is null!");
			return;
		}
		
		if (array.length < 2) {
			System.out.println("ERROR: Array is of size less than 2!");
			return;
		}
		
		int length = array.length;
		
		//n-number, index
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i<length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], i);
			}
		}
		
		for (int i=0; i<length; i++) {
			if (map.containsKey(n-array[i])) {
				System.out.println("Pair found! " + array[i] + " and " + (n-array[i]));
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,7,2,6,3,5,4,4,9,-1};
		int n = 8;
		find_pairs_n_solution(array, n);
	}

}
