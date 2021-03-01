/*
time complexity: O(n)
space comeplexity : O(1)
*/
class Solution {
    public int trap(int[] height) {
        
        
        int left = 0;
        int right = height.length-1;
        
        int lmax = 0;
        int rmax = 0;
        int result = 0;
        
        while(left < right){
            if(height[left] > lmax){
                lmax = height[left];
            }
            if(height[right] > rmax){
                rmax = height[right];
            }
            if(lmax < rmax){
                //process left side
                result += lmax - height[left];left++;
            }else{
                //process right side
                result += rmax - height[right];right--;
            }
        }
        return result;
    }
}
