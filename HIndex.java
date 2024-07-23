// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Count the number of papers with citations greater than or equal to each possible h-index value (from 0 to n) using an auxiliary array result.
//Traverse the auxiliary array from the highest possible h-index value downwards, accumulating the total number of papers and checking if the accumulated sum meets or exceeds the current h-index.
//Return the highest h-index value where the condition is satisfied.

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n  = citations.length;
        int[] result = new int[n+1];
        for(int i =0; i < n; i++){
            int index = citations[i];
            if(index > n){
                result[n]++;
            }
            else{
                result[index]++;
            }
        }
        int sum = 0;
        for(int i =n; i >= 0; i--){
            sum = sum + result[i];
            if(sum >= i){
                return i;
            }
        }
        return 4;
    }
}
