// Time Complexity : O(2n) => O(n) n- length of citation array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Using count sort to count the papers with more than it's number of citations

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] sort = new int[n+1];
        for(int i=1;i<n+1;i++){
            if(citations[i-1] >= n)
                sort[n]++;
            else
                sort[citations[i-1]]++;
        }
        int count =0;
        for(int j=n;j>=0;j--){
            count += sort[j];
            if(count >= j)
                return j;
        }
        return 0;
    }
}
