//For sorted input
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int diff = n - i;

            if (diff <= citations[i]) {
                return diff;
            }

        }
        return 0;
    }
}

//TC: O(n), SC: (1)


//Approach - 2 - Binary Search
class Solution2 {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int diff = n - mid;

            if (diff == citations[mid]) {
                return diff;
            } else if (diff > citations[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return n - l;
    }
}

//TC: O(log n), SC: (1)

//Approach 3 - for Unsorted array input
class HIndexUnsorted {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n + 1];

        int sum = 0;

        for (int num : citations) {
            if (num > n) {
                arr[n]++;
            } else {
                arr[num]++;
            }
        }

        for (int i = n; i >= 0; i--) {
            sum += arr[i];

            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}

//TC: O(2n), SC: O(1)