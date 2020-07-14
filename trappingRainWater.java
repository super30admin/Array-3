//time complexity O(n)
//space complexity O(1)

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int amount = 0;
        int l = 0; int lw = 0;
        int r = height.length-1; int rw = 0;
        while(l <= r){
            if(lw < rw){
                if(height[l] < lw){
                    amount += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {

                if(height[r] < rw){
                    amount += rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return amount;
    }
}
