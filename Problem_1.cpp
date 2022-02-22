/**
 * Time complexity:
 * O(n)
 * 
 */

/**
 * Space Complexity:
 * O(1)
 * 
 */


/**
 * Approach:
 * Two pointers approach:
 * To understand this problem first we need to understand that how the
 * water can be trapped. For trapping the water we should have a left wall
 * and right wall. We can trap the water in betwwwn these walls and amount
 * of water trapped depends on the height of the smaller wall. 
 * 
 * We assume that initially the height of both the walls is zero. Then we set
 * our left and right pointers at the left most end and the right most end
 * respectively. The first condition is that these two pointers should not cross
 * each other. To get the second condtion we have to understand a concept that
 * whichever wall is smaller in height, we have to compare that walls value
 * with that side's pointer. If the value is smaller than the pointers, we can not
 * hold the water there and we have to set the value of the wall equivalent to the
 * height pointed by that pointer. Otherwise, we are assured that we can store
 * this much water here because on the other side there will be a bigger wall and
 * update the pointers i.e. increment or decrement them by 1 depending upon which 
 * pointer it is.
 * 
 */


// Thecode ran perfectly on leetcode
class Solution {
public:
    int trap(vector<int>& height) {
        if(height.empty() || height.size() == 0) return 0;
        int lw = 0; // left wall
        int rw = 0; // righ wall
        int l = 0;  //left pointer
        int r = height.size()-1; //right pointer
        int count = 0; //water count
        
        while(l <= r){
            if(lw <= rw){
                if(height[l] < lw){
                    count += (lw - height[l])*1;
                    
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if(height[r] < rw){
                    count += rw - height[r];
                    
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return count;
        
    }
};