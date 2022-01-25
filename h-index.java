// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Time Complexity = O(nlogn)
// Space Complexity = O(1)
// Your code here along with comments explaining your approach
// Note: This problem can be optimized further from this solution, the sorting part can be replaced by a counting sort.
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int n = citations.length;

        for (int i=0; i<n; i++) {
            // diff is the h-indexes
            int diff = n-i;
            if (citations[i] >= diff) {
                return diff;
            }
        }
        return 0;
    }
}
// -------------------------------------------------------------------------------------------------------------------------
// Note: This is the optimized solution, sorting part is done by using counting sort.
// Time Complexity = O(n)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] result = new int[n+1];    // size is +1 since we need to have 0 index too

        // This for loop is for count sort
        for (int i=0; i<n; i++) {
            if (citations[i] > n) {
                result[n]++;
            }
            else {
                result[citations[i]]++;
            }
        }

        // Now calculate the h-index result
        // we add the values in each index starting from the end, and check if the sum >= index, if yes we return the index since its the h-index
        int sum=0;
        for (int i=n; i>=0; i--) {
            sum += result[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
