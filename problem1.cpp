/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
finding the right pivot to stop for both the walls.

// Your code here along with comments explaining your approach
find the pivot wall , that is the tallest from left and right.
This gaurantees that the water can be filled from either side. 
Then you move the left wall and left ptr if left ptr (which is ahead of left wall) is greater than left wall
you replace left wall with left ptr next big wall. If left ptr height less than left wall water can be stored.
Just increment left ptr. 
Do the same for the right wall. 
*/

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int max_val{-1};
        int max_idx{-1};
        int sz = height.size();
        for(int i{};i<sz;++i){
            if(height.at(i)>max_val){
                max_val = height.at(i);
                max_idx = i;
            }
        }
        // trying to fill from left hand side
        int lw{};
        int lpt{};
        int cnt{};
        while(lpt<max_idx){
            //condition to fill
            if(height.at(lpt)<height.at(lw)){
                cnt = cnt + height.at(lw) - height.at(lpt);
            }
            else{
                lw = lpt;
            }
            lpt++;
        }
        //trying to fill from right hand side
        int rw{sz-1};
        int rpt{sz-1};
        while(rpt>max_idx){
            if(height.at(rpt)<height.at(rw)){
                cnt = cnt + height.at(rw) - height.at(rpt);
            }
            else{
                rw = rpt;
            }
            rpt--;
        }
        return cnt;

    }
};