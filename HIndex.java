//Time Complexity: O(n)
//Space Complexity: O(n)
public class HIndex {
    public int hIndex(int[] citations) {
        //Bucket sort
        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int a:citations) {
            if(a >= n) {
                buckets[n] += 1;
            } else {
                buckets[a] += 1;
            }
        }

        int total  = 0;
        for(int i = n; i >=0; i--) {
            total = total + buckets[i];
            if(total >= i) return i;
        }
        return -1;
    }
}
