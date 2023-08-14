//Time Complexity (TC): O(n)
//Space Complexity (SC): O(1)

class Solution {
    public int trap(int[] height) {
        if (height==null || height.length==0) return 0;
        int n= height.length;
        
        int lw=0, l=0;
        int rw=0, r=n-1;
        int area=0;
        
        while(l<= r){
            //left
            if(lw<=rw){
                if(lw>= height[l])
                    area+= lw- height[l];
                else
                    lw= height[l];
                l++;
            }
            else{
                if(rw>= height[r])
                    area+= rw- height[r];
                else
                    rw= height[r];
                r--;
            }
        }
        return area;
    }
}
