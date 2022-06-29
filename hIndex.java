// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
//make a bucket to store number of elements having value equal to index, if value is greater than
//last index, add in last index. then calculate the sum from last until sum becomes greater than or 
//equal to the current index and return the index
class Solution {
    public int hIndex(int[] citations) {
        int[] bucket = new int[citations.length + 1];
        int sum = 0;
        // populating the bucket
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= bucket.length) {
                bucket[bucket.length - 1]++;
            } else {
                bucket[citations[i]]++;
            }

        }
        // calculating sum from end to find h index
        for (int i = bucket.length - 1; i >= 0; i--) {
            sum += bucket[i];
            if (sum >= i) {
                return i;
            }
        }
        return -1;
    }
}