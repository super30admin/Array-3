// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/


class Solution {
    //Optimized previous solution
    //time: O(n)
    //space: O(1)
    public int trap(int[] height) {
        
        int n = height.length;
        if(n==0) return 0;
        int lw = 0;
        int l = 0;
        int rw = n-1;
        int r = n-1;
        int result = 0;
        
        while(l<=r){
            
            //check rw and lw
            if(height[lw]>height[rw]){
                //process right
                if(height[rw]<=height[r]){
                    rw=r;
                    r--;
                }else{
                    result += (height[rw]-height[r]);
                    r--;
                }
            }else if(height[lw]<=height[rw]){
                //process left
                if(height[lw]<=height[l]){
                    lw=l;
                    l++;
                }else{
                    result += (height[lw]-height[l]);
                    l++;
                }
            }
            
        }
        return result;    
    }
    
}
/*
class Solution {
    //slow and fast pointer
    //time: O(n)
    //space: O(1)
    public int trap(int[] height) {
        
        int n = height.length;
        int result = 0; //global result
        int currTrap = 0; //rain water trapped now
        //find the peak
        int max = 0;
        for(int k=0; k<n; k++){
            if(height[max]<height[k])
                max=k;
        }
        
        //find the trapped water until peak
        int fast = 1;
        int slow = 0;
        while(fast<=max){
            if(height[slow]<=height[fast]){
                slow=fast;
                result+=currTrap;
                currTrap = 0;
                fast++;
            }else{
                currTrap += (height[slow]-height[fast]);
                fast++;
            }
        }
        
        //find the trapped water from the end to the peak
        fast=n-2;
        slow = n-1;
        while(fast>=max){
            if(height[slow]<=height[fast]){
                slow=fast;
                result+=currTrap;
                currTrap = 0;
                fast--;
            
            }else{
                currTrap += (height[slow]-height[fast]);
                fast--;
            }
        }
        //return the total rain water trapped
        return result;
    }
}
*/