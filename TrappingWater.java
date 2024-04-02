/**
Time Complexity: O(n), Space Complexity: O(1). Utilizes two pointers to traverse the array once, calculating trapped water based on the highest left and right walls encountered.

 */
class Solution {
    public int trap(int[] h) {
        int l =0, r = h.length-1;
        int lw=0, rw=0;
        int res =0;
        if(h == null) return 0;
        while(l<=r){
        if(rw>lw){
            if(lw>h[l]){
                res += lw-h[l];

            }
            else{
                lw = h[l];
            }
            l++;
        }
        else{
            if(rw>h[r]){
                res += rw-h[r];
            }
            else {
                rw = h[r];
            }
            r--;
        }
        
    }
    return res;
}
}
