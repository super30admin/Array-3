//Time Complexity:O(n)
//Space Complexity:O(1)
class Solution {
    public int trap(int[] height) {
        int left=0, maxLeft=0, right=height.length-1, maxRight=0, res=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>maxLeft){
                    maxLeft=height[left];
                }
                else{
                    res+=maxLeft-height[left];
                }
                left++;
            }else{
                if(height[right]>maxRight){
                    maxRight=height[right];
                }
                else{
                    res+=maxRight-height[right];
                }
                right--;
            }
            
        }
        return res;
    }
}