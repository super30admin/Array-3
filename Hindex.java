// time complexity is nlogn
// spacecomplexity is 1

import java.util.Arrays;

class Hindex {
    public int hIndex(int[] citations) {
        if (citations == null)
            return 0;
        Arrays.sort(citations);
        int j = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= j) {
                return j;
            }
            j--;
        }
        return 0;
    }
}