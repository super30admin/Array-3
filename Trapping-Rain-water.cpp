/*Time Complexity: O(3N)
Space Complexity: O(2N)
Did this code successfully run on Leetcode : Yes
Approach: First calculting prefix and suffix max and then finding the min of the 
two prefix and suffix and calculating the diff. 
Prob: 42. Trapping Rain Water
*/
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void Prefix_Max(vector<int>& height,vector<int>& PMAX,int n){
        PMAX[0] = height[0];
        for(int i=1;i<n;i++){
            PMAX[i] = max(PMAX[i-1],height[i]);
        }
    }
    void Suffix_Max(vector<int>& height,vector<int>& SMAX,int n){
        SMAX[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            SMAX[i] = max(SMAX[i+1],height[i]);
        }
    }
    int trap(vector<int>& height) {
        int n = height.size();
        int amount = 0;
        vector<int> PMAX(n),SMAX(n);
        Prefix_Max(height,PMAX,n);
        Suffix_Max(height,SMAX,n);
        for(int h=0;h<n;h++){
            int deciding_height = min(PMAX[h],SMAX[h]);
            if(deciding_height > height[h]){
                amount += deciding_height - height[h];
            }
        }
        return amount;
    }
};