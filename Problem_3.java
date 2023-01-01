// Time Complexity : O(n) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//189. Rotate Array

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(nums == null || nums.length == 0 || nums.length == 1 || nums.length == k || k == 0) return;
        int r = nums.length - 1;
        int l = 0;
        int l1 = r - k;
        int r1 = l1 + 1;
        reverse(nums, l, l1);
        reverse(nums, r1, r);
        reverse(nums, l, r);
    }
    private void reverse(int[] num, int s, int e){
        int diff = e - s + 1;
        if(diff == 1) return;
        while(s < e){
            int t = num[s];
            num[s] = num[e];
            num[e] = t;
            s++;
            e--;
        }
    }
}