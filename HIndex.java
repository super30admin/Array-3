//TC: O(n), SC: O(n)
//Approach: One way to approach this problem is to sort the citations array : O(nlogn)
//and then calculate the h-index by checking if citations[i] >= n - i
//We could sort the array using bucket sort as well, which would be O(n) TC
//start from either end, if you go from n -> i, check if current sum >= i
//if you start from 0 index, check if current sum >= n - i
public class HIndex {

    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int i : citations) {
            if (i >= n) buckets[n]++;
            else buckets[i]++;
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += buckets[i];
            if (sum >= i) return i;
        }

        return 0;
    }
}
