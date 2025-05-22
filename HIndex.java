//Time Complexity: O(NlogN)
//Space Complexity: O(1)
// https://leetcode.com/problems/h-index/

/**
 * Computes the H-index by binary searching the sorted citations array.  
 * At each step, compares the number of papers with at least mid citations to citations[mid].  
 * Returns the maximum H such that H papers have at least H citations, in O(logN) time after sorting.  
 */

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int diff = n - mid;

            if (diff == citations[mid])
                return diff;
            else if (diff > citations[mid])
                low = mid + 1;
            else {
                high = mid - 1;
            }

        }
        return n-low;
    }
}
