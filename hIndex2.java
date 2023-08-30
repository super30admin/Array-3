// Time Complexity : O(n)   -> In binary Search Approach TC -> O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class hIndex2 {
    public int hIndex(int[] citations) {

        int n = citations.length;
        /*for(int i=0; i<n; i++)
        {
            int diff = n - i;
            if(citations[i] >= diff)
            {
                return diff;
            }
        }
        return 0;*/

        // using binary search
        int low=0; int high=n-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int diff = n-mid;
            if(citations[mid] == diff)
            {
                return diff;
            }else if(citations[mid] > diff)
            {
                high = mid - 1;

            }else
            {
                low = mid + 1;
            }
        }
        return n-low;
    }

}
