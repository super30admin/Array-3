// Time Complexity : O(N) #of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. If we rotate more than n times we get same array hence rotate k%n times where k is given # of times to rotate. 
// 2. Reverse all elements and than reverse first k elements.
// 3. Finally rotate all remaining elements.


class Solution {
public:
    void reverse(vector<int>& nums,int f,int l){
        for(int i=0;i<(l-f+1)/2;i++){
            int t=nums[f+i];nums[f+i]=nums[l-i];nums[l-i]=t;
        }
    }
    void rotate(vector<int>& nums, int k) {
        int n=nums.size();
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);    
        reverse(nums,k,n-1);
        
    }
};