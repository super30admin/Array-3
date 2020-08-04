// Time = O(n) n is elements in array;
//Space = O(1);
//LeetCode : Worked


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int l = 0; int r =n-1;
        int lw = 0; int rw =0;
        int result = 0;
        while(l<=r){
            if(rw>lw){
                if(lw>height[l]){
                    result += lw - height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }
            else{
                if(rw>height[r]){
                    result += rw - height[r];
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        
        return result;
    }
}