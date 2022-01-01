// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int hIndex(int[] citations) {
        int[] arr=new int[citations.length+1];
        
        for(int i=0;i<citations.length;i++){
            if(citations[i]>arr.length-1){
                arr[arr.length-1]+=1;
            }else{
                arr[citations[i]]+=1;
            }
        }
        int prev=0;
        for(int n=arr.length-1;n>=0;n--){
            prev+=arr[n];
            if(prev>=n){
                return n;
            }
        }
        
        return -1;
    }
}