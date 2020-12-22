// Time Complexity : O(n), where n is the size of the array
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Sometimes I find it difficult to make a judgement if I need to l<r OR l<=r

//Three liner explanation of your code in plain English
//1. Create 4 pointer (left wall with left pointer AND right wall with right pointer) --> (Intuition = to trap water you need atleast
        // 2 building one on the left and other on the right. But there can be other buildings inbetween those buildings, So you need
        // 2 more pointer to find the trapping water with the left and the right building respectively)
//2. lw and l are at 0 and rw and r are at n-1. till l and r dont become equal cross, do following
        //1. if lw is smaller than right wall (water can surely trap w.r.t smaller height), move left pointer 1 step and if l is 
                //smaller than lw then water will trap between lw and l ( so add their diff to total water)
        //2. Similarly if rw is greater than lw, move r one step backward and if r is smaller than rw then water will trap between
                //r and rw (so add their diff to total water)
//3. In above case if l is greater than lw then move lw to l . Similarly if r is greater than rw then move rw to r. AND continue
        //the above steps till the while loop
        //In the end return water

// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        //edge case
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        //variable to calculate water trap
        int water = 0;
        
        //4 pointers, denoting left wall and right wall, with their left and right pointer respectively
        int lw = 0;
        int l = 0;
        int rw = n-1;
        int r = n-1;
        
        while(l<r){
            //left wall is smaller
            if(height[lw] <= height[rw]){
                //move the left pointer
                l++;
                //check if left pointer is smaller than the left wall, so as to trap water
                if(height[l] < height[lw]){
                    //water can be trapped
                    water += height[lw] - height[l];
                }else{//water can't be trapped
                    lw = l;
                }
            }else{//right wall is smaller
                //move right pointer
                r--;
                //check if right pointer is smaller than right wall, so as to trap water
                if(height[r] < height[rw]){
                    //water can trap
                    water += height[rw] - height[r];
                }else{//water can't trap
                    rw = r;
                }
            }
        }
        return water;
    }
}