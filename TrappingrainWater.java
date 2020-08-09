//time:O(n)
//space:O(1)
//leetcode:yes

class Solution {
    public int trap(int[] height) {
        //edge case
        if(height == null || height.length == 0)return 0;
        int n = height.length;
        int result = 0;
        int l = 0;
        int r = n - 1;
        int lw = 0;
        int rw = 0;//heigth NOT INDICES
        while(l <= r){
            if(lw <= rw){//operate on left hand side
                if(lw > height[l]){
                    result +=(lw - height[l]);
                }else{
                    lw = height[l];
                }
                l++;
                
            }else{//operate on right hand side
                if(rw > height[r]){
                    result +=(rw - height[r]);
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}