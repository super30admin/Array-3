// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach



class Solution {
    public int trap(int[] height) {
        int temp = 0;
        int l = height.length;
        int[] left = new int[l];
        int[] right = new int[l];

        left[0] = 0;
        right[l-1]=0;
        int j=l-1;
        //Get the max left wall and right wall for current
        for(int i =1; i<l; i++){
            left[i] = Math.max(left[i-1],height[i-1]);
            right[j-i] = Math.max(height[j-i+1],right[j-i+1]);
        }
        int temp2 = 0;
        //get the minimun out of left and right wall to calculate how much water will be stored
        for(int i = 0; i<l; i++){
            temp2 = Math.min(left[i], right[i]) - height[i];
                if(temp2>0){
                    temp = temp + temp2;
                }
            
        }

        return temp;
    }
}