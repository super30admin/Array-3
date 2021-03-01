// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class TrappingWater {
    public int trap(int[] height) {
        int a = 0;
        int b = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int max = 0;

        //while we reach the mid of the array using two pointers
        while(a<=b){
            //calculate leftMax & rightMax
            leftMax = Math.max(leftMax, height[a]);
            rightMax = Math.max(rightMax, height[b]);
            //if rightMax is greater, count water on left side and vice versa
            if(leftMax<rightMax){
                max += leftMax - height[a];
                a++;
            }
            else{
                max += rightMax - height[b];
                b--;
            }
        }

        return max;
    }
}