// approch 1
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

class Main {
    // approch 1 sorting the array
    public static int hIndex1(int[] citations) {
        // null case
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        // sort the array
        Arrays.sort(citations);
        // find the h index by finding number of citation at this index(i) greater than
        // or equal to the
        // diffrence(n-i)
        for (int i = 0; i < n; i++) {
            int diff = n - i;
            if (citations[i] >= diff) {
                return diff;
            }
        }
        return 0;
    }

    // approch 2 using bucket sort
    public static int hIndex2(int[] citations) {
        // null case
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;

        // bucket for bucket sort
        int[] b = new int[n + 1];
        // first pass add elements in buckets
        // when number of citations greater than the maximum hIndex
        // add into last index of bucket
        for (int i = 0; i < n; i++) {
            if (citations[i] > n - 1) {
                b[n]++;
            } else {
                b[citations[i]]++;
            }
        }
        // second pass start from the end and sumUp the
        // check if sum >= i then we return i as we want maximum hIndex
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += b[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = new int[] { 3, 0, 6, 1, 5 };
        System.out.println(hIndex1(citations));
        System.out.println(hIndex2(citations));
    }
}