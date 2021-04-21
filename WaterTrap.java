//TC:O(n)
//SC:O(1)
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length-1;
        int volume = 0;     //Calculating max from left and max from right,
        while(left<=right)  //Checking min of maxLeft and maxRight and calculating the amount of water can be stored at the particular point. Reapting the same till all the indices are covered.
        {
            maxLeft = Math.max(height[left],maxLeft);
            maxRight = Math.max(height[right],maxRight);
            
            if(maxLeft<maxRight)
            {
                volume = volume+(maxLeft-height[left]);
                left++;
            }
            else
            {
                volume = volume+(maxRight-height[right]);
                right--;
            }
        }
        return volume;
    }
}