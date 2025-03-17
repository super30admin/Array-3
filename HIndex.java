/*
 * TC: O(n)
 * SC: O(n)
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // use counting sort
        int[] count = new int[n + 1];

        for(int c: citations) {
            if(c >= n) {
                // put all citations >= n in the last bucket
                // since max hIndex can be n
                count[n]++;
            } else {
                count[c]++;
            }
        }

        int total = 0;
        for(int i = n; i >= 0; i--) {
            // gather the count of papers
            // with i or more citations
            total += count[i];
            // the first time this total >= i
            // is our hIndex
            if(total >= i) {
                return i;
            }
        }
        return 0;
    }
}
