//TC: O(n)
//SC: O(1)

class Solution {
public:
    int trap(vector<int>& height) {
        
        //basecase  - there needs to be atleast 3 elements to trap water
        if(height.size() < 3){
            return 0;
        }
        //using 2 pointers to store the max left and the max right values.
        //the water level at a particular block can be calculated as 
        //min(maxleft, maxright) - currentblock height.
        
        int maxleft = height[0];
        int maxright = height[height.size()-1];
        
        int left = 1;
        int right = height.size()-2;
        int trappedwater = 0;
        
        while(left <= right){
            //check if maxleft or maxright is bigger
            if(maxleft < maxright){
                //maxright is bigger so we consider maxleft
                if(height[left] > maxleft){
                    maxleft = height[left];
                } else{
                    trappedwater += maxleft - height[left];
                }
                left +=1;
                
            } else {
                //maxleft is bigger so choose maxright
                if(height[right] > maxright){
                    maxright = height[right];
                } else{
                    trappedwater += maxright - height[right];
                }
                
                right -= 1;
            }
        }
        
        return trappedwater;
    
        
    }
};