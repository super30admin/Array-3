import java.util.Arrays;

/*
 * The complexity of the algorithm is O(n) where n is no of elements in array.
 * 
 */

/*
 *  using Arrays.sort method
 * The complexity of the algorithm is O(n log n) where n is no of elements in array.
 * 
 */

public class H_Index {

	public int hIndex1(int[] citations) {

		if (citations == null || citations.length == 0)
			return 0;

		int n = citations.length;

		int[] bucket = new int[n + 1];

		for (int i = 0; i < n; i++) {

			if (citations[i] >= n) {

				bucket[n]++;

			} else {

				bucket[citations[i]]++;
			}

		}

		int sum = 0;

		for (int i = bucket.length - 1; i >= 0; i--) {

			sum += bucket[i];

			if (sum >= i)
				return i;

		}

		return 0;
	}

	// using sorting

	public int hIndex(int[] citations) {

		if (citations == null || citations.length == 0)
			return 0;
		Arrays.sort(citations);
		int n = citations.length;

		for (int i = 0; i < n; i++) {

			int diff = n - i;
			if (diff <= citations[i])
				return diff;
		}

		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
