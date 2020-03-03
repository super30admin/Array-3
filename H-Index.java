import java.util.Arrays;

//Time Complexity : O(N Log N) for Linear Search/Sorting Approach,
//O(N) for Counting Sort
//Space Complexity : O(1) for Linear Search/Sorting Appoach,O(N) for Counting Sort
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
*/
public class H_Index1 {

	public int hIndex1(int[] citations) {
		int size = citations.length;
		int count[] = new int[size + 1];

		for (int i = 0; i < size; i++) {
			count[Math.min(size, citations[i])]++;
		}
		int sum = 0;
		for (int i = count.length - 1; i >= 0; i--) {
			sum += count[i];
			if (sum >= i) {
				return i;
			}
		}
		return -1;
	}

	public int hIndex2(int[] citations) {
		// sorting the citations in ascending order
		Arrays.sort(citations);
		int idx = 0, n = citations.length;
		for (int c : citations) {
			if (c >= n - idx)
				return n - idx;
			else
				idx++;
		}
		return 0;
	}

	public static void main(String args[]) {
		int citations[] = { 3, 0, 6, 1, 5 };
		H_Index1 hIdx = new H_Index1();
		System.out.println(hIdx.hIndex1(citations));
		System.out.println(hIdx.hIndex2(citations));

	}
