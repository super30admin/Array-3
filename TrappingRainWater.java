// Time Complexity :  O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//dp
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        right[height.length - 1] = height[height.length - 1];
        for(int j = height.length - 2; j >=0; j--){
            right[j] = Math.max(right[j+1], height[j]);
        }
        
        for(int i = 1; i < height.length - 1; i++){
            ans += Math.min(right[i], left[i]) - height[i];
        }
        return ans;
    }
}

//Brute Force
// class Solution {
//     public int trap(int[] height) {
//         int ans = 0;
//         for(int i = 0; i < height.length; i++){
//             int left_max = 0;
//             for(int j = i; j >=0; j--){
//                 left_max = Math.max(left_max, height[j]);
//             }
//             int right_max = 0;
//             for(int j = i; j < height.length; j++){
//                 right_max = Math.max(right_max, height[j]);
//             }
//             ans += Math.min(left_max, right_max) - height[i];
//         }
//         return ans;
//     }
// }