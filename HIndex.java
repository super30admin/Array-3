// Problem2 H-Index (https://leetcode.com/problems/h-index/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take an array with length citations length+1. If i is citations value increase i value by 1 in result array. Whenever value in results
 * array from last is greater than i value of that value return i value.
 */
// 1
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(n-citations[i] >= citations[i]){
                count += 1;
            }
        }
        return count;
    }
}
// 2
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int []result = new int[n+1];
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                result[n]++;
            }
            else{
                result[citations[i]]++;
            }
        }
        int count = 0;
        for(int i = n; i>=0; i--){
            count += result[i];
            if(count>= i) return i;
        }
        return 0;
    }
}