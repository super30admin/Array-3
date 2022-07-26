// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//274. H-Index
//https://leetcode.com/problems/h-index/


class Solution {
    //time: O(n)
    //space: O(n)
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        int[] cit = new int[n+1];
        
        for(int i=0; i<n; i++){
            if(citations[i]>=n){
                cit[n] += 1;
            }else{
                cit[citations[i]] += 1;
            }
           
        }
        
        
        int tempResult = 0;
        int result = 0;
        for(int j=n; j>=0; j--){
           tempResult += cit[j];
           if(tempResult >= j){
               result = j;
               break;
           }
        }
        
        return result;
    }
}



/*
class Solution {
    public int hIndex(int[] citations) {
         
        //check if(citations[i] >= n-i) stop and return citations[i] 
        Arrays.sort(citations);
        
        int n = citations.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(citations[i] >= n-i){
                res = n-i;
                break;
            }      
        }
        return res;
   }
}
*/
