// TC: O(2n) //Traversing once to get max height index and another time to count the trapped water
// SC: O(1)


// We can get the max height of a wall which acts as a middle wall between left and right side
// Traverse through the array once to get the index of the tallest wall O(n)
// Once you get the index that is the right wall now
// Start with index 0 as the left wall 
// If your left wall height > than current height, you can trap water
// How much water? left wall - height[i] and add it to result
// Otherwise, your current height will be greater than left wall so make this your new left wall
// Do this until you reach right wall
// Do the same for right side, basically the right wall (max height) is now your left wall
// Right wall is now n-1, Go from right to left until you reach the left wall(max height)

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        //find index of max height
        int max=0;
        int maxIdx=0;
        for(int i=0;i<height.length;i++){
            if(max<height[i]){
                max=height[i];
                maxIdx=i;
            }
        }
        
        //left side
        int lw=height[0];
        int i=0;
        int result=0;
        while(i<maxIdx){
            // trap water
            if(lw>height[i]){
                result+=lw-height[i];
            } 
            else{
                //make this the new height
                lw=height[i];
            }
            i++;
        }
        
        //right side
        int j=n-1;
        int rw=height[n-1];
        
        while(j>maxIdx){
            if(rw>height[j]){
                result+=rw-height[j];
            } else {
                rw=height[j];
            }
            j--;
        }
        return result;
    }
}