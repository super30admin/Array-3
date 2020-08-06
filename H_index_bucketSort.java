//TC - O(N)
//SC - O(N)
class Solution4 {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int buckets[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			buckets[Math.min(citations[i], n)]++;
		}
		int sum = 0;
		for (int i = buckets.length - 1; i >= 0; i--) {
			sum = sum + buckets[i];
			if (sum >= i)
				return i;
		}
		return -1;
	}
}