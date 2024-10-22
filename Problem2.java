// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Array-3;

public class Problem2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
       int bucket  [] = new int[n+1];
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                bucket[n]++;
            }else{
                bucket[citations[i]]++;
            }
        }

        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += bucket[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}
