// Time Complexity : O(N) 

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Reverse the first half until n-k and reverse the ramining half. Finally,
// reverse the entire array to get rotated array by k

// 189. Rotate Array

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(k>n){
            k=k%n;
        }
        reverse(nums.end()-k,nums.end());
        reverse(nums.begin(),nums.begin() + (n-k));
        reverse(nums.begin(),nums.end());
    }
};