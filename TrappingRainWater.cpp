//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int left=0;
        int right= height.size()-1;
        int leftMax=0;
        int rightMax=0;
        int totalWater=0;
        while(left<right)
        {
                if(height[left]<=height[right])
                {
                    if(height[left]>leftMax)
                    {
                        leftMax=height[left];
                    }
                    else
                    {
                        totalWater=totalWater+(leftMax-height[left]);
                    }
                    left++;
                }
                else
                {
                    if(height[right]>rightMax)
                    {
                        rightMax=height[right];
                    }
                    else
                    {
                        totalWater=totalWater+(rightMax-height[right]);
                    }
                    right--;
                }
        }
        return totalWater;
    }
};