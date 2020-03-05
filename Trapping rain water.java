// Time complexity - 0(n)
// space complexity - 0(1)
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int amount = 0;
        int left =0; int right = height.length -1;
        int leftwall = 0; int rightwall = 0;
        while (left<=right) {  // Both left and right pointers are not crossing
            if(leftwall < rightwall) {// checking which wall is smaller processing from that side.
                //  leftwall is smaller
                if(leftwall < height[left]){
                    leftwall = height[left];
                }else {
                    // if found any trapping while iterating
                    amount = amount + leftwall - height[left];
                }
                left++; 
        } else {
               // right wall is bigger
                 if(rightwall < height[right]){
                    rightwall = height[right];
                }else {
                    // if found any trapping while iterating
                    amount = amount + rightwall - height[right];
                }
                right --;
            }
            
        }
        return amount;
    }
}