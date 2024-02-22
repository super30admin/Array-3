/*Time Complexity: O(N)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Approach: One pass solution - finding the max during the first pass itself.
Prob: 42. Trapping Rain Water
*/
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int curr = 0;
        int res = 0;
        int lw = 0;
        int rw = n-1;
        while(lw < rw){
            if(height[lw] <= height[rw]){
                curr = lw+1;
                while(curr < rw && height[curr] <= height[lw]){
                    cout<<"lw:"<<lw<<" curr:"<<curr<<" rw:"<<rw<<endl;
                    res += (height[lw] - height[curr]);
                    curr++;
                }
                lw = curr;
            }
            else{
                curr = rw-1;
                while(curr > lw && height[curr] <= height[rw]){
                    cout<<"else lw:"<<lw<<" curr:"<<curr<<" rw:"<<rw<<endl;
                    res += (height[rw] - height[curr]);
                    curr--;
                }
                rw=curr;
            }
        }
        return res;
    }
};