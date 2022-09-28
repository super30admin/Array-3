//TC : O(n)
//SC : (1)

class Solution {
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        int leftMax = -1;
        int rightMax = -1;
        int count=0;
        while(left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            
            if(leftMax < rightMax){
                count += (leftMax-height[left])*1;
                left++;
            }else{
                count += (rightMax-height[right])*1;
                right--;
            }
        }
        return count;
    }
}
