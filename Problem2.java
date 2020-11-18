// Time ComplexityL O(N)
// Space ComplexityL O(N)
// Passed Leetcode
class Solution {
    public int hIndex(int[] citations) {
        
        
        int[] map = new int[citations.length + 1];
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            map[Math.min(n, citations[i])]++; 
        }
        
        int total = 0;
        for (int i = n; i >= 1; i--) {
            if (map[i] + total >= i)
                return Math.min(i, map[i] + total);
            total += map[i];
        }
        return 0;
    }
}