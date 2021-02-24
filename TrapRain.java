//Time Complexity: o(n)
//Space Complexity: o(1)
//Expln: Keep traversing from left and right by verifying if the left is less than or equal to r1
// to prevent if the water overflows from left or right
//and check with l1 and l2 pointers. If not check with r1 and r2 pointers.
//If l2 < l1 or r2 < r1 then calculate water in pit else assign l1 to l2 and increment l2 similarly with right
class Solution {
    public int trap(int[] height) {
        int res =0;
        if(height.length < 2) return res;
        int l1 = 0; int l2 = 1;
        int r1 = height.length -1; int r2 = height.length-2;
        while(l1 < r1)
        {
            if(height[l1] <= height[r1]){
                if(height[l2] < height[l1])
                {
                    res += height[l1] - height[l2];
                    l2++;
                }
                else{
                l1 = l2;
                l2++;
                }
            }
            else
            {
                if(height[r2] < height[r1])
                {
                    res += height[r1] - height[r2];
                    r2--;
                }
                else{
                r1 = r2;
                r2--;
                }
            }
        }
        return res;
    }
}