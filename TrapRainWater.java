class Solution {
    // Refernce - > https://www.youtube.com/watch?v=ZI2z5pq0TqA
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;

        int result = 0;

        int l = 0, r = height.length - 1;
        // leftMax - max number on the left hand side so far
        // rightMax - max number on the right hand side so far
        int leftMax = height[l], rightMax = height[r];

        // while left and right pointer do not cross each other
        while(l < r){
            if(leftMax < rightMax){ // having this condition as leftMax <= rightMax will also work. 
                l++;
                leftMax = Math.max(leftMax, height[l]);
                result += leftMax - height[l];
            }else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                result += rightMax - height[r];
            }
        }

        return result;
    }
}
