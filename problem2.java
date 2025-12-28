// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch 
we are doing bucket sort
after creating the array start itterating from back
store all the values in a result and return where result becomes greater then index

*/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int citation : citations) {
            if (citation > n) {
                count[n] += 1;
            } else {
                count[citation] += 1;
            }
        }
        int result = 0;
        for (int j = n; j >= 0; j--) {
            result += count[j];
            if (result >= j) {
                return j;
            }

        }
        return 0;
    }
}