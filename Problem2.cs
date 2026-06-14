// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
The h-index is the maximum value of h such that the researcher has atleast published h papers that have been cited h times. We need to find the first paper at index i for which
the number of citations citations[i] is greater than or equal to n - i where n is the total number of papers. I perform binary search on the citations array. I set low = 0 and high
= last index of citations. At each pass, I calculate the mid element and check if citations[mid] >= citations.Length - mid. If so , citations.Length - mid becomes one of my 
possible solutions. I then set high = mid - 1 and find first such occurrence that satisfies the condition. If the condition is not satisfied, I set low = mid + 1. 
*/

public class Solution {
    public int HIndex(int[] citations) {
        int low = 0, high = citations.Length - 1;
        int ans = 0;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(citations[mid] >= (citations.Length - mid))
            {
                ans =  citations.Length - mid;
                high = mid - 1;
            }

            else 
            {
                low = mid + 1;
            }
        }

        return ans;
    }
}