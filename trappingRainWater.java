// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int trap(int[] height) {
        //null
        int result = 0;
        int slow = 0;int fast = 1;
        int currTrap = 0;
        //forward
        while(fast < height.length){
            if(height[fast] < height[slow]){
                currTrap += height[slow] - height[fast];
            } else {
                //fast ht is greater
                result += currTrap;
                currTrap = 0;
                slow = fast;
            }
            fast++;
        }
        int peak = slow;
        //backward pass
        currTrap = 0;
        slow = height.length - 1;
        fast = slow - 1;
        while(fast >= peak){
            if(height[fast] < height[slow]){
                currTrap += height[slow] - height[fast];
            } else {
                result += currTrap;
                currTrap = 0;
                slow = fast;
            }
            fast--;
        }
        return result;
    }
}