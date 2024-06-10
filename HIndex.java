// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes, failing for one test case with input [1,3,1]

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low =0;
        int high = n-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int diff = n - mid;
            if(citations[mid] == diff){
                return diff;
            }else if(citations[mid] > diff){
                high= mid-1;
            }else{
                low = mid+1;
            }
        }


        return n-low;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes, failing for one test case with input [1,3,1]
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        for(int i=0;i< n;i++) {
            int diff = n-i;
            if(diff <= citations[i]){
                return diff;
            }

        }

        return 0;
    }
}