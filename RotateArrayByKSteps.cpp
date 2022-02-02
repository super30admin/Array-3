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
    void rotate(vector<int>& nums, int k) {
        int lenArray=nums.size();
        k=k%lenArray;
        
        reverse(nums,0,lenArray-1);
        reverse(nums,0,k-1);
        reverse(nums,k,lenArray-1);
    }
    
    void reverse(vector<int>& nums,int i,int j)
    {
        while(i<=j)
        {
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j--;
        }
    }
};