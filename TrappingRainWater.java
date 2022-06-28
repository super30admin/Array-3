// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int trap(int[] height) {
        int answer = 0;
        if(height.length==0){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=maxLeft){
                    maxLeft = height[left];
                }else{
                    answer += maxLeft-height[left];
                }left++;
            }else{
                if(height[right]>=maxRight){
                    maxRight = height[right];
                }else{
                   answer += maxRight-height[right];
                }right--;
            }
        }
        return answer;
    }
}