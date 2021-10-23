public class HindexBucket {
    public int hIndex(int[] citations) {
        if (citations == null)
            return 0;
        int[] bucket = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length - 1)
                bucket[citations.length]++;
            else
                bucket[citations[i]]++;
        }
        int sum = 0;
        for (int h = bucket.length - 1; h >= 0; h--) {
            sum += bucket[h];
            if (sum >= h)
                return h;
        }

        return 0;
    }
}
