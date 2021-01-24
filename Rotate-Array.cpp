// Brute Force
// Time Complexity : O(k*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size()==0){
            return;
        }
        int n = nums.size();
        if(k>n){
            k = k%n;
        }
        
        for(int i=0;i<k;i++){
            int previous = nums[n-1];
            for(int j=0;j<n;j++){
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
};

//Reversing

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size()==0){
            return;
        }
        int n = nums.size();
        if(k>n){
            k = k%n;
        }
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    void reverse(vector<int>& nums, int l, int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
    
    void swap(vector<int>& nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};
