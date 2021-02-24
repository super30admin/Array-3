// Time Complexity : The time complexity is O(n) where n is the length of array
// Space Complexity : The space complexity if O(n) where n is the length of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;

        int[] cite = new int[n+1];

        //traverse and get the count of citations
        for(int num:citations){
            if(num >= n){
                cite[n]++;
            }
            else{
                cite[num]++;
            }
        }

        int count = 0;

        // Find the hindex by checking where it satisfies the definition
        for(int i=n;i>=0;i--){
            count += cite[i];

            if(count >= i){
                return i;
            }
        }

        return 0;

    }
}