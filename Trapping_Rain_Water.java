//TC:o(n)
//space:- o(1)

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int count = 0;
        
        while(left <right){
            if(maxLeft <= maxRight){
                left++;
                int sum = Math.min(maxLeft,maxRight) - height[left];
                if(sum>0){
                   count = count+ sum; 
                }
                 
            }
            else{
                right--;
                int sum = Math.min(maxLeft,maxRight) - height[right];
                if(sum>0){
                   count = count+ sum; 
                } 
            }  
            maxLeft = Math.max(height[left],maxLeft);
            maxRight = Math.max(height[right], maxRight);
    
        }
        return count;
    }
}