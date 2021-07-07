// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Have 2 pointers at start and end of array. Now move both pointers towards each other till the a height greater than previous height is reached.
// 2. Beacuse,if heights keep on increasing,no water will be trapped between them. Now once a height lower than current height is reached, 
//    fix another two pointers at these places. Now , start from pointer with lowest height and move another pointer present here and add 
//    height difference between fixed pointer and moving pointer to the result. Do this till a height greater than fixed pointer is found.
// 3.Repeat the same process till both pointers meet and return result.

public class trappingRainWater {
    public static int trap(int[] height) {
        if(height.length<3)  return 0;
        int l = 0;
        int r = height.length-1;
        int result = 0;
        while(l<r && height[l+1]>height[l])   l++;
        while(l<r && height[r-1]>height[r])   r--;
        while(l<r){
            int ptr1 = l;
            int ptr2 = r;
            if(height[ptr1]<height[ptr2]){
                while(l<r && height[ptr1] >= height[l] ){
                    result+=height[ptr1]-height[l];
                    l++;
                }
            }
            else{
                while(l<r && height[ptr2] >= height[r] ){
                    result+=height[ptr2]-height[r];
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }
}
