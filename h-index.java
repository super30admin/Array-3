
//tc is O(nlogn)
//sc is O(1)
import java.util.*;

class Solution {
    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0)
            return 0;

        int n = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < n; i++) {
            int diff = n - i;
            if (citations[i] >= diff) {
                return diff;
            }
        }

        return 0;
    }
}