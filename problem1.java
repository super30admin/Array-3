/*
 The intuition here is to put the left wall and right wall on the starting and end each

 On the bigger wall , we know that it can trap water , so we will advance a pointer from the smaller wall and keep adding the diff of heights 
 If the advance pointer is bigger than the smaller wall, then we move the smaller wall,
 when the smaller wall become bigger than the bigger wall, we will do the same process on the bigger wall
Two pointers approach

Time : O(n)
Space : O(1)
*/

class Solution {
    public int trap(int[] height) {

        int lw=0, rw = height.length-1;
        int leftA=lw, rightA = rw;

        int count = 0;

        while(leftA <= rightA){
            // check which one is smaller            

            // if left wall is smaller
            if(height[lw] <= height[rw]){
                // advance a pointer from there
                // check if the advance pointer height is bigger
                if(height[leftA] > height[lw]){
                    lw = leftA;
                }
                count+= height[lw] - height[leftA];
                leftA++;
            }
            // if right wall is smaller
            else if(height[rw] < height[lw]){
                // advance a pointer from there
                // check if the advance pointer is bigger
                if(height[rightA]> height[rw]){
                    rw = rightA;
                }
                count+= height[rw] - height[rightA];
                rightA--;
            }
        }

        return count;

        
    }
}