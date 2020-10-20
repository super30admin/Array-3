// Time Complexity : O(n) for the reverse string operations as max.
// Space Complexity : O(1) we are not creating any space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if( k > n){
            k = k%n; // if k = n that means n rotations so the resulted array will be same as given .
            
        }
        //[1 2 3 4 5 6]  if k = 2
        
        reverse(nums, 0, n-1); // [ 6 5 4 3 2 1]
        reverse(nums, 0, k-1); // [5 6 4 3 2 1 ]
        
        reverse(nums, k, n-1); // [ 5 6 1 2 3 4]
    }
    
    
    void reverse(vector<int>& nums, int i, int j){
        
        while ( i < j){
            
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            i++;
            j--;
            
        }
        
    }
};