package Dec16;

class TrappingRainWater {
	
    public int trap(int[] height) {
        /*
        Time Complexity: O(n) because we are iterating through array only once by moving left or right pointer at a time.
        Space Complexity: O(1) 
        
        Approach:
        Left wall pairs up with Left ptr.
        Right wall pairs up with Right ptr.
        So, 2 ptrs. Left wall and Right wall.(These are height values, not indices)
        And other 2 ptrs.Left and Right.(These are indices)
        
        1) Check if left wall is bigger or right wall is bigger. Whichever is smalller, process that one first.
        2) Check if height at right ptr. > right wall. 
        If yes, no trap is possible.  Move right wall to right ptr.
        If no, trap is possible. Calculate trap amt. Decrement right pointer.
        
        Check if height at left ptr. > left wall. 
        If yes, no trap is possible. Move left wall to left ptr.
        If no, trap is possible.Calculate trap amt. Increment left pointer.
        
        */
        
        // edge
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int result = 0;
        int n = height.length;
        int left = 0, right = n-1;
        int leftWall = height[0], rightWall = height[n-1];
        
        while (left <= right) {
            // check which wall is smaller
            if (leftWall <= rightWall) {
                // process left side
                if (height[left] < leftWall) {
                    // then only we can trap water
                    result += leftWall - height[left];
                } else {
                    leftWall = height[left];
                }
                left++;
            } else {
                // process right side
               if (height[right] < rightWall) {
                    // then only we can trap water
                    result += rightWall - height[right];
                } else {
                    rightWall = height[right];
                }
                right--; 
            }
        }
        
        return result;
        
    }
}