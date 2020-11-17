// Time Complexity : O(N) - As we iterate the whole array
// Space Complexity : O(N) - As we use a additional 1D array for counting sort
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
  public int hIndex(int[] citations) {
      int n = citations.length;
      int[] bucket = new int[n  + 1];
      for(int i = 0;i < n;i++){
         int c = citations[i];
          if(c >= n) bucket[n]++;
          else{
              bucket[c]++;
          }
      }
      int count = 0;
      for(int i = n;i >=0;i--){
          count = count + bucket[i];
          if(count >= i) return i;
      }
      return 0;
  }
}
// Your code here along with comments explaining your approach