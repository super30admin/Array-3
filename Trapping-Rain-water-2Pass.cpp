/*Time Complexity: O(2N)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Approach: First pass for findind maxIdx, left traverse till the maxIdx and 
right traverse till maxIdx by calculating amount.
Prob: 42. Trapping Rain Water
*/
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int maxH = 0;
        int maxIdx = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            if(maxH < height[i]){
                maxH = height[i];
                maxIdx = i;
            }
        }
        // left traversal till maxIdx
        int i = 0;
        int lw = 0;
        while(i < maxIdx){
            if(height[i] < lw){
                res += lw - height[i];
            }
            lw = max(lw,height[i]);
            i++;
        }
        // right traversal till maxIdx
        i = n-1;
        int rw = 0;
        while(i > maxIdx){
            if(height[i] < rw){
                res += rw - height[i];
            }
            rw = max(rw,height[i]);
            i--;
        }
        return res;
    }
};