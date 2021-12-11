class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int l = 0; int r = height.length-1;
        
        int lw = 0; int rw = 0; int amount = 0;
        
        while(l <= r){
            if(lw < rw){
                if(height[l] < lw){
                    amount += lw - height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(height[r] < rw){
                    amount += rw - height[r];
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return amount;
        
        
    }
}

//TC: O(N)
//SC: O(1)
