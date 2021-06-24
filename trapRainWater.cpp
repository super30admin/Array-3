/*Intuition: Here we will make an imaginary left wall and right wall to see how much water is trapped 
between the left wall and left pointer and right wall and right pointer.
/////////////////////////////////
Time Complexity: O(N)
Space Complexity: O(1)
/////////////////////////////////

*/
class Solution {
public:
    int trap(vector<int>& height) {
        int leftWallHeight = 0, rightWallHeight = 0;
        int leftIndex = 0, rightIndex = height.size()-1;
        int result = 0;
        while (leftIndex <= rightIndex){
            if ( leftWallHeight <= rightWallHeight){
                
                if ( leftWallHeight > height[leftIndex])
                    result += 1* (leftWallHeight - height[leftIndex]);
                else
                    leftWallHeight = height[leftIndex];
                leftIndex++;
            
            }
            else{
                if ( rightWallHeight > height[rightIndex])
                    result += 1* (rightWallHeight - height[rightIndex]);
                else
                    rightWallHeight = height[rightIndex];
                rightIndex--;
            
            }
        }
        return result;
    }
};