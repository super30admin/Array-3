// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * 1 - This is a two pass algorithm.
 * 2 - In the first forward pass, we can trap water only if slow > fast i.e. a taller building exists after slow pointer.
 * Once we reach a taller building than slow, add the water amount to the result and perform backward pass upto the peak.
 * 3 - In the backward pass, the same logic applies
 */

public class TrapWater {
    public int trap(int[] height) {
        if(height.length == 0 || height == null)
        {
            return 0;
        }
        
        int n = height.length;
        int slow = 0;
        int fast = 1;
        int currTrap = 0;
        int result = 0;
        
        //forward pass
        while(fast < n)
        {
            if(height[slow] > height[fast])
            {
                currTrap += height[slow] - height[fast];
            }
            else
            {
                result += currTrap;
                slow = fast;
                currTrap = 0;               
            }
            fast++; 
        }
        
        int peak = slow;
        currTrap = 0;
        slow = n - 1;
        fast = n - 2;
        
        //backward pass
        while(fast >= peak)
        {
            if(height[slow] > height[fast])
            {
                currTrap += height[slow] - height[fast];
            }
            else
            {
                result += currTrap;
                slow = fast;
                currTrap = 0;
            }
            fast--;
        }
        
        return result;
    }
}
