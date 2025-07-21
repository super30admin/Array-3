/*
 * TC: O(n) n: length of height
 * SC: O(1)
 * 
 * Approach: My approach would be to calculate area for a particular heigh with referenc to my leftWall and RightWall. Intially, 
 * my Left Wall would be the first element and right wall would be the last element. At each iteration i will choose the height
 * which is smaller thean the other.And calculate the area and add tot he result i.e leftWall/rightWall - height[i] and accordingly i will
 * update my pointers.
 */

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i =0;
        int j = n-1;
        int leftWall = height[i];
        int rightWall = height[n-1];
        int result =0;

        while(i<j){
            if(height[i] < height[j]){
                leftWall = Math.max(leftWall, height[i]);
                result += leftWall - height[i];
                i++;
            }else{
                rightWall = Math.max(rightWall, height[j]);
                result += rightWall - height[j];
                j--;
            }
        }
    return result;  
    }
}