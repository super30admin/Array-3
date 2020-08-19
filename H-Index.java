//Time Complexity: O(n)
//Space Complexity :O(n)
//Did it run on leetcode : yes
// The main idea here is use the bucket sort and count the number of 
//citation whenever the citation crosses the index return the index


class Solution {
    public int hIndex(int[] citations) {
        
      int n = citations.length;
      int sum = 0;
      int[] buckets = new int[citations.length+1]; 
        
        //perform count sort -> count the number of citations.
      for(int i = 0 ; i < citations.length; i++){
          if(citations[i] > n)
              buckets[n]++;
          else
           buckets[citations[i]]++;
      }
        
    //Calculate the citations if the citation is greater than the index return the index.
      for(int i=buckets.length-1; i>=0 ; i--){
          sum+=buckets[i];
          if(sum >= i)
              return i;
          
      }
        
        return  0;
        
    }
}