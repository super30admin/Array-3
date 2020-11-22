class Solution {// time of O(n) and space of O(1) two pointer approach.
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        //base case 
        if(height.length == 0)
            return 0;
        int leftmax = 0;
        int rightmax = 0;
        int result = 0;
        while(left< right){
            leftmax = Math.max(leftmax , height[left]);
            rightmax = Math.max(rightmax , height[right]);
            if(leftmax < rightmax){
                result += leftmax - height[left++] ; 
            }else{
                result += rightmax - height[right--];
            }
        }
        return result;
    }
}