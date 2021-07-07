//Time complexity is O(N)
//Space complexity is O(N)
//This solution is submitted on leetcode

public class BigN115HIndexUsingTopologicalSort {
	class Solution {
		public int hIndex(int[] citations) {
			// edge case
			if (citations == null || citations.length == 0)
				return 0;
			int n = citations.length;
			int[] arr = new int[n + 1];
			for (int i = 0; i < citations.length; i++) {
				arr[Math.min(citations[i], n)]++; 
			}
			int sum = 0; 
			for (int i = n; i >= 0; i--) { 
				sum += arr[i];
				if (sum >= i)
					return i;
			}
			return -1;
		}
	}
}