// Time complexity = O(n)
// Space complexity = O(n)
// The idea is that the range of the h-index is going to lie between 0 and the length of the array(n). so we can consider all values greater than or equal to the length in one index.
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n+1];
        for(int i=0;i< n;i++) {
            if(citations[i]>= arr.length) {
                arr[n]++;
            }
            else {
                arr[citations[i]]++;
            }
        }
        // the arr is filled.
        // now get the h-index
        int sum=0;
        for(int i=n;i>=0;i--) {
            sum+= arr[i];
            if(sum>= i) return i;

        }

        return 0;
    }
}