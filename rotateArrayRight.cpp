// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Reverse full array, then reverse first k elements, then reverse remaining elements
// 2. Take care to make k=k%n to handle k>n cases

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(!n)
            return;
        // if k>n
        k = k%n;
        // reverse whole array
        reverse(nums, 0, n-1);
        // reverse first k
        reverse(nums,0,k-1);
        // reverse last n-k
        reverse(nums, k, n-1);
    }
    void reverse(vector<int>& nums, int start, int end){
        while(start<end){
            swap(nums[start], nums[end]);
            start++;
            end--;
        }
    }
    
    void swap(int& a, int& b){
        int temp = a;
        a=b;
        b = temp;
    }
};