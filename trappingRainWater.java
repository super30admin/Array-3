class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 2) return 0;
        int result = 0;
        int n = height.length;
        int left = 0;
        int lw = 0;
        int right = n - 1;
        int rw = 0;
        
        //until left does not cross right 
        while(left <= right){
            //if left wall is smaller than right wall, process left side  
            if(lw <= rw){
                //if left wall is smaller than left then add to result
                if(lw > height[left]){
                    result += (lw - height[left]) * 1;  
                }
                // move the left wall to left pointer 
                else{
                    lw = height[left];
                }    
                left++;
            }
            else{
                if(rw > height[right]){
                    result += (rw - height[right]) * 1;  
                }else{
                    rw = height[right];
                }    
                right--;
                
            }
        }
        return result;
    }
}
