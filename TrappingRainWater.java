/*
Time Complexity: O(N), N is the number of elements in the heights array
Space Complexity: O(1), Constant space
Run on leetcode: yes
Any difficulties: No

Approach:
1. I am solving this problem using two pointers left and right, based on the value at the left and right index I will be
iterating given heights array
2. To Trap rain water, the area should be enclosed uniformly , and to do so, I will be considering heights on each left and
right index
 */
public class TrappingRainWater {
    public static int trapRainWater(int[] heights){
        if(heights.length == 0){
            return 0;
        }

        int left = 0;
        int right = heights.length-1;
        int leftMaxHeight = 0, rightMaxHeight = 0;
        int ans = 0;
        while(left<right){
            if(heights[left]>leftMaxHeight){
                leftMaxHeight = heights[left];
            }
            if(heights[right]>rightMaxHeight){
                rightMaxHeight = heights[right];
            }
            if(leftMaxHeight<rightMaxHeight){
                ans+= Math.max(0, leftMaxHeight-heights[left]);
                left++;
            }else{
                ans+= Math.max(0, rightMaxHeight-heights[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("Trapping rain water: "+trapRainWater(heights));
    }
}
