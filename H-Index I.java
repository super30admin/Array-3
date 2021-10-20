// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

// h index is difference where h of the pages > h citation and  n-h papers <=h
//1. using bucket sort : take a bucket of n+1 size Note : here bucket index is citation
//2 now run a for loop in main array and calculate no of citation of same type and add that to index( citation in bucket
// 3 now in bucket array from last element, start checking sum wherever sum >= citaion(bucket index ) return that index


class Solution {
    public int hIndex(int[] citations) {
        
       // Arrays.sort(citations);
       
        int n = citations.length;
        int[] bucket = new int[n +1];
        for(int i = 0 ; i < citations.length; i++)
        {
          int  bucketIndex = citations[i]; //citations are bucket index now
            
            // if citation is greater than last index of bucket then add 1 in last element'value
            if(bucketIndex > bucket.length -1)
              bucket[bucket.length -1] =  bucket[bucket.length -1] +1;
            else  bucket[bucketIndex] = bucket[bucketIndex] +1;
            
        }
        
        // start from last index of bucket and sum no of citation greater than this index i.e citation
          int sum=0 ;
          for(int i = bucket.length-1 ; i >=0 ; i--)
          {
              sum = sum + bucket[i];
              // if sum is greater than citation i.e bucket indec than resturn 
              if(sum >= i )
                  return i;
          }
        
        return 0;
    }
}