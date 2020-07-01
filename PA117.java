//Leetcode : 42. Trapping Rain Water
//Time Complexity: O(n)
//Space Complexity:O(1)
class Solution {
    public int trap(int[] height) {
        int lmax=0;
        int rmax=0;
        int water=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            if(height[i]<height[j]){
                 if(lmax<height[i]){
                    lmax= height[i];
                }
                else{
                    water= water+(lmax-height[i]);
                }
                i++;
            }
            else{
                 if(rmax<height[j]){
                    rmax= height[j];
                }
                else{
                    water= water+(rmax-height[j]);
                }
                j--;
            }
           
        }
        
      return water;  
    }
}