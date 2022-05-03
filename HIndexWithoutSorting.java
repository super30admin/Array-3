//Time Complexity O(NLog N)
//Space Complexity O(1)
//Leetcode tested

import java.util.Arrays;

public class HIndexWithoutSorting {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int diff = n - i;
            if(diff<=citations[i]) return diff;
        }
        return -1;
    }
}
