/* 
    Time Complexity                              :  O(2*N) - first 2 reverse operations reverses the array part wise and the last reverse operation reverses the array completely.
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std; 


class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        useReverse(nums,k);
    }
    
    void useReverse(vector<int>& nums, int k) {
        int n = nums.size();
        k = k%n;
        reverse(begin(nums) + n-k, end(nums));
        reverse(begin(nums), begin(nums)+n-k);
        reverse(begin(nums), end(nums));
    }
};