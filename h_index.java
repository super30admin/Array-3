// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        
        int size = citations.length;
        int[] h_array = new int[size+1]; 
        int sum = 0;
        
        for(int c:citations){
            if(c >= size){
                h_array[size]+=1;
            }
            else{
                h_array[c]+=1; 
            }
        }
        
        for(int i = h_array.length-1; i>=0; i--){
            sum+=h_array[i];
            if(sum>=i){
                return i;
            }
        }
        
        return 0;
    }
}