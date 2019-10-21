/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
189. Rotate Array
Easy

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Note:

    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?


 * Solution 1: using array elements shifting  
   Time Complexity : O(n^2)
 * Space complexity :O(1)

 */

class Solution {
public:
    /* NEED TO IMPROVE IT. CURRENTLY ITS O(n^2) solution */
    void rotate(vector<int>& nums, int k) {
        int save_temp = 0;
        int i,j;
        
        /* Calculate final rotations */
        int final_rotations = k % nums.size();
        k = final_rotations;

        if (k == 0) {
            return;
        }
        /* shift the numbers to the left one by one such that at the end k elements are the start of the array */
        for (i = nums.size() - k - 1; i >= 0; i--) {
            save_temp = nums[i];
            for (j = i; j < (k+i); j++) {
                nums[j] = nums[j+1];
            }
            nums[j] = save_temp;
        }
    }
};
/* Execute on leetcode platform */


