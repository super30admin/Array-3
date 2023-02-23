// Time Complexity = O(2n)
// Space Complexity = O(1)

class Solution {
    public int trap(int[] height) {
        int max = 0;
        int maxIdx = 0;
        int maxHeight = 0;
        int n = height.length;
        
        for(int i = 0; i < n; i++){
            if(maxHeight < height[i]){
                maxHeight = height[i];
                maxIdx = i;
            }
        }
        int i = 0;
        int lw = height[0];
        int result = 0;
        while(i < maxIdx){
            if(lw > height[i]){
                result += lw - height[i];
            }
            else{
                lw = height[i];
            }
            i++;
        }
        
        int j = n-1;
        int rw = height[n-1];
        while(j> maxIdx){
            if(rw > height[j]){
                result += rw - height[j];
            }else{
                rw = height[j];
            }
            j--;
        }
        return result;
    }
}



