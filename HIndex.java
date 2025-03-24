// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(nlogn), SC = O(1)
    // public int hIndex(int[] citations) {
    //     if(citations == null || citations.length == 0) return 0;
    //     Arrays.sort(citations);
    //     int n = citations.length;
    //     for(int i = 0; i < n; i++) {
    //         if(citations[i] >= n - i) {
    //             return n - i;
    //         }
    //     }
    //     return 0;
    // }

    // TC = O(n), SC = O(n)
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] result = new int[n + 1];
        for(int i = 0; i < n; i++) {
            int index = citations[i];
            if(index >= n) result[n]++; // collect these citations at the end as the h index will never be > n
            else result[index]++; // number of papers with citations = i
        }
        int sum = 0;
        for(int i = n; i >= 0; i--) { // from end as we have to give max value as h index
            sum += result[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}