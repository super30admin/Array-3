// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use bucket sort to count citation frequencies.
//   - Create a bucket array of size (n+1), where n is the number of papers.
//   - For each citation c, increment bucket[c] if c < n, else increment bucket[n].
//   - Traverse from high to low, summing counts until the cumulative count ≥ index i.
//   - Return i as the h-index.

public class HIndex {
    //bucket sort - TC - O(2n), SC - O(n)
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for(int element: citations) {
            if(element >= n) {
                buckets[n]++;
            } else {
                buckets[element]++;
            }
        }
        int sum = 0;
        for(int i = n; i >= 0; i--) {
            sum += buckets[i];
            if(sum >= i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        HIndex obj = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        int hIndex = obj.hIndex(citations);
        System.out.println("H-Index is: " + hIndex);
        // Expected: 3
    }
}
