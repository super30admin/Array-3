// Time Complextiy : O(n)
// Space complexity : O(1)
class Solution {
    public int trap(int[] h) {
        int n = h.length; 
        int lw = 0 , rw = 0; 
        int l = 0 , r = n-1;
        int water =0;

        while(l<=r){
            if(lw<rw){
                if(h[l]<lw) water+=(lw-h[l]);
                else lw= h[l];
                l++;
            }
            else{
                if(h[r]<rw) water+=(rw-h[r]);
                else rw = h[r];
                r--;
            }
        }
        return water;
    }
}
