//Time Complexity: O(N)
//Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        //edge case
        if(height == null)return 0;
        int lmax =0, rmax =0;
        int low = 0, high = height.length-1;
        int result =0;
        
        while(low<high){
            if(height[low]<height[high]){
                if(height[low]>lmax){
                    lmax = height[low];
                }else{
                    result += lmax-height[low];
                }
                low++;
            }
            else{
                if(height[high]>rmax){
                    rmax = height[high];
                }else{
                    result+=rmax-height[high];
                }
                high--;
            }
        }
        return result;
    }
}