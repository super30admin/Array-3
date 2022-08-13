// Approach - Initializing a separate vector
// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        vector<int> answer;
        int n = nums.size();
        k = k%n;
        for(int i = n-k; i < n; i++)
            answer.push_back(nums[i]);
        
        for(int i = 0; i < n-k; i++)
            answer.push_back(nums[i]);
        
        nums = answer;
    }
};


// Approach - Reversal Algorithm
// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    private:
    void swap(vector<int>& arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
    void rev(vector<int>& arr, int s, int e){
        while(s < e){
            swap(arr, s, e);
            s++;
            e--;
        }
    }
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k%n;
        rev(nums, 0, n-k-1);
        rev(nums, n-k, n-1);
        rev(nums, 0, n-1);
    }
};