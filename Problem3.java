/*
h-index ii
approach: h index always lies between 0 and total papers, so do a binary search to find max value of h indexes
time: O(log n)
space: O(1)
 */
public class Problem3 {
    public int hIndex(int[] citations) {

        int l = 0, h = citations.length-1, n = citations.length;

        while(l<=h) {
            int m = l+(h-l)/2;

            if(citations[m]<n-m) l = m+1;
            else h = m-1;
        }

        return n-l;
    }
}
