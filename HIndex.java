// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
      int[] buckets = new int[n+1];
      for(int i =0;i<n;i++){
          if(citations[i]>=n){
              buckets[n]++;
          }
          else{
              buckets[citations[i]]++;
          }
      }
      int sum = 0;
      for(int i=n;i>=0;i--){
          sum+=buckets[i];
          if(sum>=i){
              return i;
          }
      }
      return 0;
    }
}