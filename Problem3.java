
//Time Complexity - O(nlogn)
//Space Complexity - O(1)

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int left = 0, right = n - 1;

        //find the first 'index' where (citations[i] >= n - i)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // (n - mid) papers with an equal or higher citation count than citations[mid]
            if (citations[mid] == n - mid)
                return citations[mid];  // optimal result and can be returned right away
            if (citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        
        return n - left;

    }
}