package Array3;

public class HIndex {
    /* Created by palak on 8/13/2021 */

    /*
        TC: O(n)
        SC: O(n)
    */
    public int hIndex(int[] citations) {
        if(citations == null)   return 0;

        int n = citations.length;
        int[] buckets = new int[n + 1];
        for(int i = 0 ; i < citations.length ; i++) {
            if(citations[i] >= n) {
                // Put in Last Bucket
                buckets[n] += 1;
            } else {
                buckets[citations[i]] += 1;
            }
        }
        int sum = 0;
        for(int i = n ; i >= 0 ; i--) {
            sum += buckets[i];
            if(sum >= i)    return i;
        }
        return 9999;
    }

    public static void main(String[] args) {

    }
}
