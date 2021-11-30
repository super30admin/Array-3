//Timecomplexity:- O(N);
//spacecomplexity:- O(1);
//Did it run on leetcode:- YES.
//What was the problem, you faced?:- took lot of time to come up with an idea.
//Your code with approach:- One basic hint is that low height is the level with which water can be stored. And other
//basic hint is that between two heights if there is a pillar of middle height subtracting middle pillar height from
//low height one. So based on this idea doing in two pointer approach based on heights of left max and right max for each point.

class Solution {
    public int trap(int[] height) {
        int leftmax=0;
        int rightmax=0;
        int area=0;
        int left=0;
        int right=height.length-1;
        while(left<=right){
            leftmax=Math.max(leftmax,height[left]);
            rightmax=Math.max(rightmax,height[right]);
            if(leftmax<rightmax){
                area=area+leftmax-height[left];
                left++;
                
            }
            else{
                area=area+rightmax-height[right];
                right--;
            }
        }
        return area;
    }
}