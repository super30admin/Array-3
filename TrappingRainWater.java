class Solution {

    //Time Complexity: 0(n) where n is the different elevations
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief, explain your approach

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int n = height.length - 1;  //finding the length of the height array
        int rw = 0; //right wall whose height will be 0 initially
        int lw = 0; //left wall
        int l = 0;  //left pointer to start from left
        int r = n;  //right pointer to start from end
        int result = 0; //result to store the total trapped rainwater
        while(l <= r){  //running a while loop when left pointer is less than or equal to the right pointer
            if(lw <= rw){   //checking if left wall is less than or equal to the right wall, move left
                if(lw > height[l]){ //if left wall if greater than the height of the right elevation, we assume that there is a place where rainwater can be trapped and store it in result
                    result = result + lw - height[l];
                }
                else{
                    lw = height[l]; //otherwise we assignt the new left wall to the next elevation
                }
                l++;    //we increase left pointer to traverse the array forward
            }
            else{   //if height of right wall is greater than we move right and capture if we can trap rainwater there or not
                if(rw > height[r]){ //of right wall is greater than the next elevations, then we trap the rainwater and store it in result
                    result = result + rw - height[r];
                }
                else{
                    rw = height[r]; //otherwise we assign the next elevation as new right wall
                }
                r--;    //decrementing right pointer to traverse the array and move forward
            }
        }
        return result;
    }
}