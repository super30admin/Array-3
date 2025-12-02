'''
189 Rotate Array
https://leetcode.com/problems/rotate-array/description/

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative. Do not return anything, modify nums in-place instead.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

Follow up:
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

Solution:
1. Brute Force
Take the last element in the array and place it at the first index. This takes O(N). Repeat this step k-1 more times shifting the element from the last index and placing it at the first index. Thus, O(N) + O(N) + ... k times = O(Nk)
Time: O(Nk), Space: O(1)

2. Split and merge
Let array indices are 0, ...,  N-(k+1),  N-k, ..., N-2, N-1.
Split the array after the N-(k+1)th element into two partitions. Then we have in the first half and k elements in the second half.
first half =  [0, ...,  N-(k+1)] (N-k elements)
second half = [N-k, ..., N-2, N-1] (k elements)
Now merge the two arrays by going through the second half and then the first half.
Time: O(N), Space: O(N)

3. Reverse and merge
Similar to #2, split the array after the N-(k+1)th element into two partitions.
first half =  [0, ...,  N-(k+1)] (N-k elements)
second half = [N-k, ..., N-2, N-1] (k elements)
Reverse the first partition, reverse the second partition, then reverse the entire array.
https://youtu.be/aslfns1i0yY?t=2500
Time: O(N), Space: O(1)
'''

from typing import List

def rotate(nums: List[int], k: int) -> None:
    def reverse(nums, left, right):
        while left <= right:
            nums[right], nums[left] = nums[left], nums[right]
            left += 1
            right -= 1

    if not nums or k == 0:
        return nums
    N = len(nums)
    k = k % N # handle cases where k > N

    # Step 1: reverse 1st partition
    reverse(nums, 0, N-k-1)
    # Step 2: reverse 2nd partition
    reverse(nums, N-k, N-1)
    # Step 3: reverse the entire array
    reverse(nums, 0, N-1)

    # Note: Step 1 and Step 2 are interchangeable. It will not change the
    # result. But Step 3 should always be done at the last.

def run_rotate():
    tests = [([1,2,3,4,5,6,7], 3, [5,6,7,1,2,3,4]),
             ([-1,-100,3,99],  2, [3,99,-1,-100]),
    ]
    for test in tests:
        nums, k, ans = test[0], test[1], test[2]
        print(f"\nnums = {nums}")
        print(f"k = {k}")
        nums_rotated = nums.copy()
        rotate(nums_rotated, k)
        print(f"rotated nums = {nums_rotated}")
        success = (ans == nums_rotated)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_rotate()