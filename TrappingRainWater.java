/*
* Approach 1: Vertical water trapping strategy
- The idea is to find the tallest wall that will act as a dam to hold water from both the sides
- We need to track the tallest wall ecountered on the left side of the current height(lw) and similary we need to keep track of the tallest wall encountered on the right when parsing through the heights from the right
- While iterating the height from the 0th element to the tallest wall, 
    - if lw < height[i] -> that means for the elements moving forward, that should act as a lw, so move lw to i
    - if lw > height[i] -> that means, we can trap water between the current building and the left wall
- Similary when moving from right to the tallest wall,
    - if rw < height[i] -> that means for the elements moving forward, that should act as a rw, so move rw to i
    - if rw > height[i] -> that means, we can trap water between the current building and the right wall
TC: O(2n) -> O(n) -> one pass to get the tallest building, and another pass to traverse the array from right and left till the tallest building
SC: O(1) -> no additional space used
*/

class Solution {
    public int trap(int[] height) {
        int lw = 0;
        int rw = height.length - 1;
        int tallest = 0;
        int total = 0;

        //find max height wall which will act as a dam
        for(int i = 0; i < height.length; i++){
            if(height[i] > height[tallest])
                tallest = i;
        }

        // count total water trapped from left to the tallest height building
        for(int i = 0; i < tallest; i++){
            if(height[lw] > height[i]){
                //we can trap water of unit difference of left wall(tallest wall on the left) and current height
                total += height[lw] - height[i];
            }
            else if(height[lw] < height[i]){
                //move the lw to current greater height encountered
                lw = i;
            }
        }

        // count total water trapped from right to the tallest height building
        for(int i = rw; i > tallest; i--){
            if(height[rw] > height[i]){
                total += height[rw] - height[i];
            }
            else if(height[rw] < height[i])
                rw = i;
        }
        return total;
    }
}