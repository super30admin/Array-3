//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to //compute the researcher's h-index.
// TC O(N) SC O(N)
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] bucket = new int [n+1];
        for (int i = 0; i<citations.length; i ++) {
            if (citations[i] >= n) {
                bucket[n]++;
            }
            else {
                bucket[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = n; i >=0 ; i--) {
            sum += bucket[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
