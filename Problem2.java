import java.util.*;

class Problem2 {
    public static int hIndex(int[] citations) {
        /*
         * 1. Iterate h from n to in sorted array
         * 2. Count sort, apply running sum on freq matrix (written below)
         */
        /* finding the max element */
        int len = citations.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, citations[i]);
        }
        /* creating a freq matrix */
        int[] freqMatrix = new int[max + 1];
        Arrays.fill(freqMatrix, 0);
        for (int i = 0; i < len; i++) {
            freqMatrix[citations[i]]++;
        }
        /* creating a suffix matrix */
        int[] suffixMatrix = new int[max + 1];
        suffixMatrix[max] = freqMatrix[max];
        for (int i = max - 1; i >= 0; i--) {
            suffixMatrix[i] = suffixMatrix[i + 1] + freqMatrix[i];
        }
        /* finding h-index */
        for (int h = max; h > 0; h--) {
            if (suffixMatrix[h] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = new int[] { 3, 0, 1, 6, 5 };
        System.out.println(hIndex(citations));
    }
}