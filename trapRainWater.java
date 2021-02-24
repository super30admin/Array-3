class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        
        int result = 0;int n = height.length;
        //heights of the left and right walls(not the indices)
        int lw = 0;int rw = 0;
        
        //initializing the left and right pointers
        int l = 0; int r = n-1;
        
        while(l<=r){
            //checking which side to operate
            if(lw <= rw){
                //processing left side
                if(lw > height[l]){
                    result += lw - height[l];
                }
                else{
                    lw = height[l];
                }
                l++;
            }
            else{
                //processing right side
                if(rw > height[r]){
                    result += rw - height[r];
                }
                else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}

//time complexity: O(n)
//space complexity: O(1)
