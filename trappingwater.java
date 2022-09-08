// tc: O(n)
// sc: O(1)

class Solution {
    // when we are not sure move left or right tak four pointers
    public int trap(int[] h) {
        int n=h.length;
        int l=0;
        int lw=0;
        int rw=0;
        int r=n-1;
        int result=0;
        
        while(l<=r){
            if(lw<=rw){
                if(h[l]<lw){
                    result += lw-h[l];
                }else{
                    lw=h[l];
                }
                l++;
            }else{
                if(h[r]<rw){
                    result += rw-h[r];
                }else{
                    rw=h[r];
                }
                r--;
            }
        }
        return result;
    }
}
