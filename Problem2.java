/*
h-index
approach: our h index always lies between 0 and the number of papers given, so we take counts for each index from 0 to papers+1
time: O(n)
space: O(n)
 */
public class Problem2 {
    public int hIndex(int[] citations) {
        int[] t = new int[citations.length+1];
        int n = citations.length;
        for(int i=0;i<citations.length;i++) {
            if(citations[i]>=n) {
                t[n]++;
            }
            else {
                t[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i=n;i>=0;i--) {
            sum = sum+t[i];
            if(i<=sum) {
                return i;
            }
        }
        return 0;

    }
}
