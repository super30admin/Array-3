class Solution {
    // One pass method using two walls left wall, right wall
    public int trap(int[] height) {
        int n = height.length;
        int lw = 0;
        int rw = n-1;
        int r =n-1;int l =0;
        int result =0;

        while(l<=r){
            //which side to process
            if(height[lw]<=height[rw]){//left side
                if(height[l]<height[lw]){ 
                    result+= height[lw] - height[l];
                }else{
                    lw = l;
                }
                l++;
            }else{
                if(height[r]<height[rw]){
                    result+= height[rw] - height[r];
                }else{
                    rw = r;
                }
                r--;
            }
        }
        return result;
    }
}
