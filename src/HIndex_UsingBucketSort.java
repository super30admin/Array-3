// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english - 


class Solution {
    
    //O(n) time, O(n) space solution using the bucket sort
    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0) return 0;
        
        //sort array using bucket sort
        int[] res = bucketSort(citations);
        
        int n = citations.length;
        
        //res is a array having citations as indices and count of papers having i citations at res[i]
        int sum = 0;
        for(int i=res.length-1; i>= 0; i--) {
            sum+=res[i];
            
            if(sum >= i) return i;
            
        }
        
        return 0;
    }
    
    //O(n) time, O(n) space
    private int[] bucketSort(int[] arr) {
        int[] res = new int[arr.length+1];
        
        for(int i=0; i< arr.length; i++) {
            if(arr[i] < arr.length){
                res[arr[i]]++;
            }else { // citations value more than array length does not matter, we can add it to the last index
                res[res.length-1]++;
            }
        }
        
        return res;
    }
}