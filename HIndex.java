// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * In this problem, the array is not sorted. We can use nlogn approach by sorting the array first, then calculating 
 * the difference and then finding the h-index.
 * 2 - But, we have used bucket sort in this problem where we have required O(n) TC.
 * 3 - If in an array, we have to sort few elements according to a range, then we use bucket sort. All elements 
 * greater than n will be put in the last bucket.
 * 4 - In the end, we simply check when the sum becomes equal to the  of i. 
 */

public class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
        {
            return 0;
        }
        
        int n = citations.length;
        
        int[] buckets = new int[n + 1];
        for(int i = 0; i < n;i++)
        {
            if(citations[i] > n)
            {
                buckets[n]++;
            }
            else
            {
                buckets[citations[i]]++;
            }
        }
        
        int sum = 0;
        for(int i = n; i >=0;i--)
        {
            sum += buckets[i];
            if(sum >= i)
            {
                return i;
            }       
        }
        return 0;
    }
}
