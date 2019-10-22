//Time complexity: O(n)
//Space Complexity : O(1)
//Take 2 pointers l and r.l starting at 0 index and right at the last index of the nums array. While the l is less than r if the geight at l position is smaller than the height at the l+1th position.Increment l
//and while the height at r position is lesser than the height at r-1 th position then decrement r. while l is lesser than r check if height at l index is lesser than height at right index.
//if left<right  then while left is greater than the height at ++l position add to ans the difference between the ;eft and the height at current l.
//else add to ans the difference between height at r and right. FInally return ans.
class Solution {
    public int trap(int[] height) {
        int ans = 0; 
        int l = 0, r=height.length-1;
        while(l<r && height[l]<=height[l+1]) l++;
        while(l<r && height[r]<=height[r-1]) r--;
        while(l<r)
        {
            int left = height[l];
            int right = height[r];
            
            if(left<=right)
            {
                while(l<r && left >=height[++l])
                {
                    ans +=left -height[l];
                }
            }
            else
            {
                while(l<r && height[--r] <= right)
                {
                    ans += right - height[r];
                }
            }
        }
        return ans;
    }
}