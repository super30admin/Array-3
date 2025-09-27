
//Time Complexity: O(n)
// Space Complexity: O(1)

//we use two pointers to find the left wall and right wall along with the current left and right index
//if we have a bigger right wall, we just worry about the left wall
//if we have a bigger left wall, we just worry about the right wall
//we can trap water if the current wall is smaller than the left/right wall
//we update the left/right wall if we find a bigger one
//we move the left pointer when we have a bigger right wall, otherwise we move the right pointer

class Solution {
    public int trap(int[] height) {
        int n=height.length,res=0;
        int l=0,lw=0;
        int r=n-1,rw=n-1;
      
        while(l<r){
            if(height[r]>height[l]){  // we do have a bigger right wall, just worry about the left wall
                if(height[lw]>height[l]){
                    res+=height[lw]-height[l];
                }else
                    lw=l;
                l++;
            }else{     // we do have a bigger left wall, just worry about the right wall
                if(height[rw]>height[r])  
                    res+=height[rw]-height[r];
                else
                    rw=r;
                r--;
            }
        }
        return res;
    }
}