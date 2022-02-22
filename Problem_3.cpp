/**
 * Time Complexity:
 * O(n)
 * 
 */

/**
 * Space complexity:
 * O(1)
 * 
 */

/**
 * Approach:
 * There are many approaches to do this.
 * 
 * The given array is first reversed and then the first
 * k elements are reversed and then the remaining elements
 * are reversed. To take care of the edge case where the
 * number of roattions are greater than the size of the
 * given array we are taking k%n. For example, the size 
 * is 10 and we have to do 11 rotations. So in the final
 * result if we observe we can do this only by one rotation
 * That is why we are taking k = k%(size of vector)
 * 
 */


//The code ran perfectly on leetcode

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.empty() || nums.size() == 0) return;
        int n = nums.size();
        k = k%n;
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin() + k);
        reverse(nums.begin() + k, nums.end());
        
    }
};