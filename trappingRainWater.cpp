#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We take two pointers one on the left and the other at the end of the array
we also store the left element and the right element, now we compare the left and the right element 
and check for the maximum of left element and add it to the result, finallt we return the result
*/
class Solution{
public:
    int trappingRainWater(vector<int>& height){
        int left = 0, right = height.size()-1;
        int leftMax = height[left], rightMax = height[right];
        int water = 0;
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = max(leftMax, height[left]);
                water += leftMax - height[left];
            }
            else{
                right--;
                rightMax = max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }
};
