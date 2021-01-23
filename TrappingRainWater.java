// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

//Initialize left to 0 and right to size -1
//If height[left] < height[right] -- If height[left] > lmax, update lmax to height[left]
//add lmax - height[left] to result and increment left
//If height[left] >= height[right] -- If height[right] > rmax, update rmax to height[right]
//add rmax - height[right] to result and decrement right

class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length == 0) return 0;
        
        int low = 0, high = height.length - 1;
        int lmax = 0, rmax = 0;
        int result = 0;
        
        while(low < high) {
            
            if(height[low] < height[high]) {
                
                if(height[low] > lmax) {
                    lmax = height[low];
                }
                else {
                    result += lmax - height[low];
                }
                low++;
            }
            else 
            {
                if(height[high] > rmax) {
                    rmax = height[high];
                }
                else 
                {
                    result += rmax - height[high];
                }
                high--;
            }
        }
        return result;
        
    }
}