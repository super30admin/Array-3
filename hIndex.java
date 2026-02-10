// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// O(nlogn,1) -> sort array and do linear scan with n-i papers with c[i]
// O(n,n) -> bucket sort with n+1 buckets
// buc[i] number of papers with i citations and keep a counter for papers with >=i citations
// if number of citations <= number of papers return i

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucs = new int[n + 1];
        for (int c : citations) {
            if (c >= n)
                bucs[n]++;
            else
                bucs[c]++;
        }

        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += bucs[i];
            if (i <= cnt)
                return i;
        }

        return 0;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++)
            if (n - i <= citations[i])
                return n - i;
        return 0;
    }
}