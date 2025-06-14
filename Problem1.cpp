// Time Complexity : O(N) #of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Find the largest wall 'm' and all the elements on left side of wall will store water if that wall is smaller than 'm'. 
// 2. Also if we are traversing from left to right max wall till the current wall should also be greater hence the amount stored is difference between size of this wall and current wall.
// 3. Similarly traverse from last right wall to left till largest wall and add all stored water while traversing.

class Solution {
public:
    int trap(vector<int>& height) {
        int n=height.size();
        int m=-1,mi=0;
        for(int i=0;i<n;i++){
            if(m<height[i]){m=height[i];mi=i;}
        }
        int lw=0,ans=0;
        for(int i=0;i<mi;i++){
            if(height[lw]>height[i]){
                ans=ans+(height[lw]-height[i]);
            }
            if(height[i]>height[lw]){lw=i;}
        }
        int rw=n-1;
        for(int i=(n-1);i>mi;i--){
            if(height[rw]>height[i]){
                ans=ans+(height[rw]-height[i]);
            }
            if(height[i]>height[rw]){rw=i;}
        }
        return ans;
    }
};