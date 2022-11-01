// Time Complexity : O(LogN)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Binary search. Here the main logic is maintaining the number of papers greater than of equal to nums[i] citations
this is obtained by reversing nums length to 1.
*/
public class HIndex2 {
    public int hIndex(int[] citations) {

        int low=0, high=citations.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(citations[mid]==citations.length-mid){
                return citations.length-mid;
            }else if(citations[mid]<citations.length-mid){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return citations.length-low;
    }
}
