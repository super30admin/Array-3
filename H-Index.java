// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain a buckets array to capture the number of citations at each index and all the citations that are greater than the size of array are
// placed at the last index. Now we loop from end of the buckets array and maintain update the count at each index. At any point if we get count to be greater
// than or equal to i, that means thera are atleast i citations, so that is is H-index.

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        int count = 0;
        for (int c : citations) { //construct an array bucket
            if (c >= n){ //greater than size elements to be placed at end of array
                buckets[n]++;
            }
            else{
                buckets[c]++;
            }
        }
        for(int i = n; i >= 0 ;i--){
            count += buckets[i]; //calculate count
            if(count >= i){ //h-index found
                return i;
            }
        }
        return 0;
    }
}