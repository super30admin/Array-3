// Time Complexity : O(n), where n is the size of the array
// Space Complexity :O(n), where n is the size of the array (used for bucket sort)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explantion of your code in plain English
//1. sort the citations array using bucket sort (O(n)).
//2. traverse the bucket sort array from last index, and at every index check if the total number of papers is greater than or equal
        //to the current index(in the bucket sort array, index represents the citations)

// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        //edge case
        if(citations.length == 0) return 0;
        int n = citations.length;
        //create an extra array for bucket sort
        int[] sorted = new int[n+1];
        
        //bucket sort
        for(int i=0; i<n; i++){
            if(citations[i] >= n){
                sorted[n]++;
            }else{
                sorted[citations[i]]++;
            }
        }  
        int numPapers = 0;
        for(int i=n; i>=0; i--){
            numPapers += sorted[i];
            if(numPapers >= i) return i;
        }
        return 0;
    }
}