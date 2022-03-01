https://leetcode.com/submissions/detail/651534937/
//Time: O(N)
//Space: O(1)
public class Solution {
    public int Trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int low = 0;
        int high = height.Length - 1;
        int water = 0;
        
        while(low <= high) {
            
            //high will be standing a bar which is already greater than left max
            if(height[low] < height[high]) {
                
                if(height[low] > leftMax) {
                    
                    leftMax = height[low];
                    
                } else {
                    
                    water += leftMax - height[low];
                    
                }
                low++;
            } else {
                
                if( height[high] > rightMax){
                    
                    rightMax = height[high];
                } else {
                    water += rightMax - height[high];
                }
                high--;
            }
        }
        
        return water;
    }
}
