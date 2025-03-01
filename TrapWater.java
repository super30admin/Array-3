class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public int trap(int[] height) {
        

        int lw =0, rw = 0;
        int l = 0, r = height.length-1;
        int total = 0;
    while (l<=r){
        if (height[l] < height[r]){
            // move l side
            if (lw > height[l]){
                total = total + (lw - height[l]);
            } else {
                lw = height[l];
            }
            l++;

        } else {
            //move r side
                  if (rw > height[r]){
                total = total + (rw - height[r]);
            } else {
                rw = height[r];
            }
            r--;

        }
    }
    return total;
}
}
