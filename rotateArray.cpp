/*Intuition:  Reverse the array.
Reverse it again from 0, to k elements
and then reverse the remaining elements.
/////////////////////////////////
Time Complexity: O(N)
Space Complexity: O(1)
/////////////////////////////////

*/
//Rotate to left
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if ( nums.size()==0 ) return;
        k = k % nums.size();
        int n = nums.size();
        reverse(nums, 0, nums.size()-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, nums.size()-1);
    }
    void reverse(vector<int>& nums, int start, int end){
        while ( start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    void swap(vector<int>& nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
};
//Rotate to right
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if ( nums.size()==0 ) return;
        k = k % nums.size();
        int n = nums.size();
        reverse(nums, 0, nums.size()-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.size()-1);
    }
    void reverse(vector<int>& nums, int start, int end){
        while ( start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    void swap(vector<int>& nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
};