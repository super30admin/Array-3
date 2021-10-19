//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                bucket[n]++;
            }
            else {
                bucket[citations[i]]++;
            }
        }
        
        int sum = 0;
        for(int i = bucket.length - 1; i >= 0; i--) {
            sum = sum + bucket[i];
            if(sum >= i) {
                return i;
            }
        }
        return 0;
    }
}