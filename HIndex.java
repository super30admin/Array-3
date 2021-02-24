// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use the bucket sort technique idea, where you increment the count of citation between 0 - n, and put the rest of it to the n+1 th index. Start iterating from the end to check if sum is greater than i.

public class HIndex {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int n = citations.length;
        int[] h = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            if(citations[i] < n)
                h[citations[i]] = h[citations[i]] + 1;
            else
                h[n] = h[n] + 1;
        }
        
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum = sum + h[i];
            if(sum >= i){
                return i;
            }
        }
        
        return 0;
    }
}
