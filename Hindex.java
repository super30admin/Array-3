package Array3;

import java.util.Arrays;

/*S30 FAANG Problem #117 {Medium} - https://www.youtube.com/watch?v=hP9SdQV2HR0
    
    For an array of citations of a researcher, Compute the researcher's h-index.
    H index can be defined as: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

    Example:
    Input: citations = [3,0,6,1,5]
    Output: 3 
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
                 received 3, 0, 6, 1, 5 citations respectively. 
                 Since the researcher has 3 papers with at least 3 citations each and the remaining 
                 two with no more than 3 citations each, her h-index is 3.
    Note: If there are several possible values for h, the maximum one is taken as the h-index.
    Source Link: https://leetcode.com/problems/h-index/
        -------------------------------------------------------------------------------------------------------
        Time complexity : O(N) 
        space complexity: O(N) 
        Approach:
        Did this code run successfully in leet code : yes
        problems faces : no*/


public class Hindex {
    
 public int hIndexBruteForce(int[] citations) {
     
     if(citations == null || citations.length == 0) return 0;
     
     Arrays.sort(citations);
     int n = citations.length;
     for(int i=0; i< n;i++)
     {
         int diff = n-i;
         if(diff <=citations[i])
         {
             return diff;
         }
     }
     
     return 0;
        
    }
 
 public int hIndexWithBucket(int[] citations) {
     
     if(citations == null || citations.length == 0) return 0;
     int n = citations.length;
     int[] buckets = new int[n+1];
     
     for(int i=0;i<n;i++)
     {
         if(citations[i] >= n)
         {
             buckets[n] += 1;
         }
         else
         {
             buckets[citations[i]] += 1;
         }
     }
     int sum =0;
     for(int i=n; i>=0;i-- )
     {
         sum += buckets[i];
         if(sum>=i) return i;
     }
         
     return 90001; 
 }  
     
}
