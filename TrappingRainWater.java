// Time Complexity : O(3n) => O(n) n- length of heights array
// Space Complexity : O(n) for left[] and right[] arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Using Dynamic programming approach

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0) return 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.max(height[i],left[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(height[i],right[i+1]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res += Math.min(left[i],right[i])-height[i];
        }
        return res;
    }
}

// Approach2: Using no extra space and just two pointers approach

// Time Complexity : O(n) n- length of heights array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Using Dynamic programming approach

class Solution {
    public int trap(int[] height) {
        int left=0,right = height.length-1;
        int leftMax=0,rightMax=0;
        int area =0;
        while(left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax<rightMax){
                area = area+(leftMax - height[left]);
                left++;
            }
            else{
                area = area+(rightMax - height[right]);
                right--;
            }
        }
        return area;
    }
}
