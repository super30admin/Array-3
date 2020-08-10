/*
For trapping rain water 
left wall must be greater than left pointer or
right wall must be greater than right pointer

Approach 
1. if left wall is greater than right wall then use right wall (ie process always the  smaller wall side) to calculate the trapped water
2. If left wall is lesser than left pointer move left wall to the left pointer and proceed left pointer one step ahead.
3. If right wall is lesser than right pointer move right wall to the right pointer position and right pointer to one step ahead

4. STOP when left and right pointer crossed each other

Executed on leetcode

*/

class Solution {
    public int trap(int[] height) {
      if(height == null || height.length == 0 )   return 0;
      
      int n = height.length;
       int result = 0; int leftPtr = 0; int rightPtr = n-1;
       int leftWall = 0; int rightWall = 0;
       while(leftPtr <=rightPtr){  // stop when leftwall and right wall cross each other condition
	   //process left wall side
       if(leftWall <= rightWall){ 
           if(leftWall > height[leftPtr]){
               result+= (leftWall - height[leftPtr] )* 1 ; //width = 1
           }
           else{
               leftWall = height[leftPtr];
           }
           leftPtr++;
       }
        else{ // process right wall side
             if(rightWall > height[rightPtr]){
                result+=(rightWall - height[rightPtr])*1;
            }
            else{
                rightWall = height[rightPtr];
            }
          rightPtr--;           
        }
       }
        return result;
    }
}

/*
Time complexity :O(n)
Space complexity:O(1)
*/