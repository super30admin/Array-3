import java.util.Arrays;

public class HIndex {
//        TC:O(nlogn)
//        SC:O(1)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;

        for (int i = 0; i < len; i++) {
            int h = len - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
    public int hIndex2(int[] citations) { //Array is already sorted
        int n = citations.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (citations[mid] >= n - mid) {
                // Check the left side for a potentially higher H-index
                right = mid - 1;
            } else {
                // Check the right side
                left = mid + 1;
            }
        }

        return n - left;
    }
}
