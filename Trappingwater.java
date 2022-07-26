//Time : O(n)
//Space :O(1)

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int result = 0;
        int currTrap = 0;
        int slow = 0;
        int fast = 1;
        // forward pass
        while (fast < height.length) {
            if (height[fast] < height[slow]) {
                currTrap += height[slow] - height[fast];
            } else {
                result += currTrap;
                currTrap = 0;
                slow = fast;
            }
            fast++;
        }
        currTrap = 0;
        int peak = slow;
        slow = height.length - 1;
        fast = slow - 1;
        while (fast >= peak) {
            if (height[fast] < height[slow]) {
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