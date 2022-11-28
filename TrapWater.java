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


/*
 * Approach 2 - Single Pass Algorithm
 * 1 - We maintain a left wall, left pointer and a right wall and a right pointer. 
 * 2 - Check which side is to be processed first by checking the height of the left and right wall. If the left wall is smaller
 * in height, right wall acts as a dam so process left side first and vice versa.
 * 3 - Check if the left pointer height is smaller than the left wall to trap water. IF yes, add to the result. If not,
 * shift the left wall to the left pointer and increment left pointer in both the cases. Perform same checks when processing the right side
 * 4 - In the end, return the result.
 * TC - O(n)
 * SC - O(1)
 */

public int trap(int[] height) {
    int l = 0;
    int r = height.length - 1;
    
    int lw = 0;
    int rw = 0;
    int result = 0;
    
    while(l <= r)
    {
        if(lw <= rw)
        {
            //left side
            if(height[l] < lw)
            {
                result += lw - height[l];
            }
            else
            {
                lw = height[l];
            }
            l++;
        }
        else
        {
            //right
            if(height[r] < rw)
            {
                result += rw - height[r];
            }
            else
            {
                rw = height[r];
            }
            r--;
        }
    }
    return result;
}
