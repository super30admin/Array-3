/* 
    Time Complexity                              :  O(3*N) due to the 3 for loops
    Space Complexity                             :  O(2*N) to store the left max and right max
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> lm(n,0);
        vector<int> rm(n,0);
        lm[0] = height[0];
        rm[n-1] = height[n-1];
        for(int i=1;i<n;i++) {
            lm[i] = max(lm[i-1],height[i]);
        }
        
        for(int i=n-2;i>=0;i--) {
            rm[i] = max(rm[i+1],height[i]);
        }
        
        int ans=0;
        for(int i=0;i<n;i++) {
            ans += min(lm[i],rm[i]) - height[i];
        }
        
        return ans;
    }
};