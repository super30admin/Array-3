189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.


Answer:-

TC :- O(n)
SC:- O(1)
class Solution {
public:

    void reverse (vector<int>& nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right]; 
            nums[right] = temp;
            left ++; right--;
        }
    }

    void rotate(vector<int>& nums, int k) {
        if (nums.size() == 0) {
            return;
        }
        int n = nums.size();
        if (k > n) {
            k = k%n;
        }
        reverse (nums, 0, n-k-1);
        reverse (nums, n-k, n-1);
        reverse (nums, 0, n-1);
    } 
};


