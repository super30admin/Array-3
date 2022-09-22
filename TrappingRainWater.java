//Approach - 1: leftPoiner, rightPointer & leftWall, rightWall
//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public int trap(int[] height) {
        int result = 0;
        int n = height.length;
        //left and right Pointers
        int leftP = 0; int rightP =  n-1;
        //left and right Walls
        int leftW = 0; int rightW = 0;

        while(leftP<=rightP){
            //which side to process left or right
            if(leftW<=rightW){
                //move to left Pointer side
                if(height[leftP]<leftW){
                        //area of water we can store 
                        result += leftW - height[leftP]; // area = (Lw-Lp) * 1 
                }
                else{
                        //move the leftWall
                        leftW = height[leftP];
                }
                leftP++;
            }
            else{
                //move to right Pointer side
                if(height[rightP]<rightW){
                        result += rightW - height[rightP]; // area = (Lw-Lp) * 1 
                }
                else{
                        rightW = height[rightP];
                }
                rightP--;
            }
        }
        return result;
    }
}
