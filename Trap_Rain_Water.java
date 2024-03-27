class Solution {
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        int leftwall =0;
        int rightwall = 0;
        int result =0;
        while(left <= right) {
            if(leftwall < rightwall) {
                if(leftwall > height[left]) {
                   result = result + (leftwall - height[left]);
                } else{
                    leftwall = height[left];
                }
                left++;
            } else {
             if(rightwall > height[right]) {
                   result = result+(rightwall - height[right]);
                } else{
                    rightwall = height[right];
                }   
                right--;
            }
        }
        return result;
    }
}