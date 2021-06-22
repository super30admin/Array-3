//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int hIndex(int[] citations) {
        
        
        //Arrays.sort(citations);
        
        int[] bucketSort = new int[citations.length + 1];
       // int n =  result.length;
        for(int i = 0; i < citations.length; i ++)
        {
            
           if(citations[i] < bucketSort.length){
               
               bucketSort[citations[i]] =  bucketSort[citations[i]] + 1;
           }
            else{
                
                bucketSort[bucketSort.length-1] =  bucketSort[bucketSort.length-1] + 1;
            }
        }      
        int sum = 0;
        for(int i = bucketSort.length-1; i >= 0; i --){
            
            sum = sum + bucketSort[i];
            
            if(sum >= i){
                
                return i;
            }
        }
        
        return 0;
    }
}