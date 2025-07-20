//Time Complexity : O(n)
//Space Complexity : O(n)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int trap(vector<int>& height) {
        int n=height.size();
        vector<int>ml(n);
        ml[0]=height[0];
        for(int i=1;i<n;i++)
        {
            ml[i]=max(ml[i-1],height[i]);
        }
        vector<int>mr(n);
        mr[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            mr[i]=max(mr[i+1],height[i]);
        }
        int water=0;
        for(int i=0;i<n-1;i++)
        {
            water+=min(ml[i],mr[i])-height[i];
        }
       return water;
    }
};