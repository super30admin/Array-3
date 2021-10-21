// Time Complexity : O(n), We used bucket sort and traversed once through the array.
// Space Complexity : O(n),A bucket list is created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        int[] buckets = new int[citations.length+1];
//Store citations according to index in bucket list
        for(int i = 0;i<citations.length;i++){
            if(citations[i]<buckets.length){
                buckets[citations[i]]++;
            }
            else{
//Any citations greater than length of array are stored at end index as answer cannot be greater than last index. Hence, doesnt matter.
                buckets[citations.length]++;
            }
        }
        int sum =0;
//We sum all from end of array until sum equls index.
        for(int i = buckets.length-1;i>=0;i--){
            sum+=buckets[i];
            if(sum>=i)return i;
        }
        return 0;
    }

}