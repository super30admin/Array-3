/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
First reverse the complete array.
Rotate the first half with k elements
Rotate the other half with n-k elements
*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
    void swap(int& a,int& b){
        int temp = a;
        a = b;
        b = temp;
    }
    void reverse(vector<int>& nums,int s_idx,int e_idx){
        while(s_idx<e_idx){
            swap(nums.at(s_idx),nums.at(e_idx));
            s_idx++;
            e_idx--;
        }
    }
    // void display(vector<int>& nums){
    //     for(int& i:nums){
    //         cout<<i<<" ";
    //     }
    //     cout<<endl;
    // }
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k%n;
        reverse(nums,0,n-1);
        //display(nums);
        reverse(nums,0,k-1);
        //display(nums);
        reverse(nums,k,n-1);
        //display(nums);
    }
};