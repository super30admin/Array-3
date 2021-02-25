//Problem 118 : Trapping Rain Water-In Place, Using 4 Pointers
//TC: O(N)
//SC: O(1)

/*Steps
    Bruteforce: TC:O(n^2) : Find minimum and maximum for each element, and then find difference between the minimum and current element height.

    Optimized:Using 4 Pointers - TC:O(N) | SC:O(1)
    
*/

class Solution118InPlace {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        //Using 4 pointers
        //TC:O(N)
        //SC:O(1)
        
        int l = 0;
        int r = height.length-1;
        int lw = 0;//left wall
        int rw = 0;//right wall
        int result = 0;
        
        while(l<=r){
            //Which ever side is lower process that
            //if left wall is smaller or equal to the right wall then process left side
            if(lw<=rw){
                
                //if left wall is greater than the left then only we can create a container and water can be stored
                if(lw>height[l]){
                    result += lw-height[l];//this much water we can store            
                }else{
                    //reset the left wall
                    lw = height[l];
                }
                l++;
            }else{ //if right wall is smaller or equal to the left wall then process right side
                
                //if right wall is greater than the right then only we can create a container and water can be stored
                if(rw>height[r]){
                    result += rw-height[r];
                }else{
                    rw = height[r];
                }
                
                r--;
            }
            
        }
        
        return result;
        
    }
}