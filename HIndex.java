// TC: O(n)
// SC: O(n)

public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int res[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n)
                res[n]++;
            else
                res[citations[i]]++;
        }
        int acc = 0;
        for (int i = n; i >= 0; i--) {
            acc += res[i];
            if (acc >= i)
                return i;
        }
        return 0;
    }
}
