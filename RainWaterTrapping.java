// Time Complexity : O(3N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int max=0;
        int maxId=-1;

        for(int i=0;i<n;i++){
            if(height[i] > max){
                max = height[i];
                maxId = i;
            }
        }

        int l=0;
        int lw=0;
        int res=0;
        while(l < maxId){
            if(lw > height[l]){
                res += lw- height[l];
            }else{
                lw = height[l];
            }
            l++;
        }
        int r = n-1;
        int rw=0;

        while(r > maxId){
            if(rw > height[r]){
                res += rw - height[r];
            }else{
                rw= height[r];
            }
            r--;
        }

        return res;
    }
}
// T = O(N)
// S = O(1)
class Solution {
    public int trap(int[] height) {
        int left=0;
        int right = height.length-1;

        int left_max = 0;
        int right_max = 0;
        int result=0;

        while(left < right){
            if(height[left] < height[right]){
                left_max= Math.max(left_max, height[left]);
                result += left_max - height[left];
                left++;
            }else {
                right_max = Math.max(right_max, height[right]);
                result += right_max - height[right];
                right--;
            }
        }

        return result;
    }
}