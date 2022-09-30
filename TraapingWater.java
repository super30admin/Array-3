// Using 4 pointers

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lw = 0, rw = 0;
        int res = 0;
        
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] < lw)
                    res += lw - height[left];
                else
                    lw = height[left];
                
                left++;
            }
            else{
                if(height[right] < rw)
                    res += rw - height[right];
                else
                    rw = height[right];
                
                right--;
            }
        }
        return res;
    }
}

//Time Complexity :O(n)
//Space Complexity :O(1)