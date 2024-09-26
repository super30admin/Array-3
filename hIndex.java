// Time Complexity : O(N) we traverse once for filling the bucket. Then we traverse bucket array once to find the index.
// Space Complexity : O(N) used extra array to store the count
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class


// Your code here along with comments explaining your approach
//use bucket sort and running sum

class Solution {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int n = citations.length;
        int count = 0;
        
        //initialize array for bucket
        int[] buck = new int[n+1];
        
        //fill the bucket
        for(int i=0; i<n; i++){
            if(citations[i] < n){
                buck[citations[i]] += 1;
            }else{
                buck[n] += 1;
            }
            
        }
            
        //calculate the running sum, when index <= count return that index 
        for(int i=n; i>=0; i--){
            System.out.println(i + " " + buck[i]);
            count += buck[i];
            if(i <= count){
                return i;
            }
        }
        
        return 0;
    }
}