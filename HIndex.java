/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
* 
* Space Complexity: O(n)
* 
*/

public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] buckets = new int[n + 1];

        for (int citation : citations) {
            if (citation > n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }

        int totalCitations = 0;

        for (int hIndex = n; hIndex >= 0; hIndex--) {
            totalCitations += buckets[hIndex];

            if (totalCitations >= hIndex) {
                return hIndex;
            }
        }

        return -1;
    }
}
