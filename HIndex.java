
// Using Sorting and Linear Search
// TC: O(n log n)
// SC: O(1)

// Using Bucket Sort
// TC: O(n)
// SC: O(n)

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(hIndexLinear(new int[] { 3, 0, 6, 1, 5 })); // 3
        System.out.println(hIndexLinear(new int[] { 1, 3, 1 })); // 1

        System.out.println(hIndexBucketSort(new int[] { 3, 0, 6, 1, 5 })); // 3
        System.out.println(hIndexBucketSort(new int[] { 1, 3, 1 })); // 1
    }

    // Sort first and then traverse from end
    public static int hIndexLinear(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int n = citations.length;
        int i = 0;
        while (i < n && citations[n - i - 1] > i) {
            i++;
        }
        return i;
    }

    // Sorting array in buckets which contributes to O(n) TC.
    // Extra array is used for storing the citations indexes value.
    public static int hIndexBucketSort(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int index = citations[i];
            if (index > n) {
                index = n;
            }
            arr[index]++;
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += arr[i];
            if (sum >= i) {
                return i;
            }
        }
        return 1231;
    }

}