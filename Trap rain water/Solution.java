//Time Complexiyu: O(n)
// space Complexity: O(1)


class Solution {
    //Optimized previous solution
    //time: O(n)
    //space: O(1)
    public int trap(int[] height) {

        int n = height.length;
        if(n==0) return 0;
        int lw = 0;
        int l = 0;
        int rw = n-1;
        int r = n-1;
        int result = 0;

        while(l<=r){

            //check rw and lw
            if(height[lw]>height[rw]){
                //process right
                if(height[rw]<=height[r]){
                    rw=r;
                    r--;
                }else{
                    result += (height[rw]-height[r]);
                    r--;
                }
            }else if(height[lw]<=height[rw]){
                //process left
                if(height[lw]<=height[l]){
                    lw=l;
                    l++;
                }else{
                    result += (height[lw]-height[l]);
                    l++;
                }
            }

        }
        return result;    
    }

}
