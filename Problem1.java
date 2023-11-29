// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lp = 0, lw = height[0], rp = n -1, rw = height[n-1];
        int cnt = 0;
        while(lp <= rp){
            if(lw <= rw){
                cnt += Math.max(0,lw-height[lp]);
                lw = Math.max(lw,height[lp]);
                lp++;
            }
            else{
                cnt += Math.max(0,rw-height[rp]);
                rw = Math.max(rw,height[rp]);
                rp--;
            }
        }
        return cnt;
    }
}
