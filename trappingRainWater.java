//Time Complexity:O(n)
//Space Complexity:O(1)

class Solution {
    public int trap(int[] height) {
        //sanity check
        if(height == null || height.length == 0)
            return 0;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int n = height.length - 1;
        int left = 0, right = n;
        
        int area = 0;
        
        while(left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            
            //calc area
            if(leftMax < rightMax){
                area = area + (leftMax - height[left]);
                left++;
            }
            else{
                area = area + (rightMax - height[right]);
                right--;
            }
        }
        return area;
    }
}