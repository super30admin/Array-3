// Time Complexity : O(n)
//      n: size of height array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach 1: Using two pointer
// 1. We will be having two pointer-> left and right. And also a imaginary wall for both.
// 2. Check which wall is smaller and process on that side.
// 3. For the side which we are processing, if its height is less than wall length 
//    we know that we can trap water. So we update the result.
// 4. If height is greater then it becomes the wall size.
// 5. We will continue to process till the two pointer cross each-other.
class Problem1 {

    /** Trapped water */
    public int trap(int[] height) {
        
        // initialize
        int result = 0;

        // edge case
        if(height != null && height.length != 0){

            // initialize
            int r = height.length-1; // right pointer
            int l, lw, rw; // left pointer, left-wall, right-wall
            l = lw = rw =0;
            
            // iterate till it crosses
            while(l<= r){

                // go left side
                if(lw <= rw){

                    // tap water on left
                    if(height[l] < lw){
                        result  += lw - height[l];
                    // update wall
                    }else{
                        lw = height[l];
                    }
                    l++; //update
                // go right side
                }else{
                    // tap water on right
                    if(height[r] < rw){
                        result  += rw - height[r];
                    // update wall
                    }else{
                        rw = height[r];
                    }
                    r--; // update
                }
            }
            
        }
        // return result
        return result;
    }
}