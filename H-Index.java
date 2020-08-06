// Time Complexity: O(NlogN)
// Space Complexity: O(1)

class Solution {
	public int hIndex(int[] citations) {
		int n = citations.length;
		Arrays.sort(citations);
		for (int i = 0; i < n; i++) {
			int diff = n - i;
			if (citations[i] >= diff)
				return diff;
		}
		return 0;
	}
} 

// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int i =0;i<n;i++){
            buckets[Math.min(citations[i],n)] ++ ; 
        }
        int sum =0;

        for(int i = n;i>=0;i--){
            sum += buckets[i];
            if(sum>=i) return i;
        }
        return 0;
    }
} 