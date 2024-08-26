# Solution

# // Time Complexity : Brute Force - O(N*K)
#                      Optimized Approach - O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Optimized approach is to reverse the array and then reverse the first K elements and last n-k elements
# https://www.youtube.com/watch?v=ZEjyrZgNdJQ

def reverse(start,end,arr):
        while end>start:
            newVal = arr[end]
            arr[end] = arr[start]
            arr[start] = newVal

            start += 1
            end -= 1

def rotate(nums, k):
    """
    Do not return anything, modify nums in-place instead.
    """
    n = len(nums)
    times = k%n

    if times != n:
        reverse(0,n-1,nums)
        reverse(0,times-1,nums)
        reverse(times,n-1,nums)

# Bruteforce
# n = len(nums)
# times = k%n
# while times>0:
#     times -= 1

#     i = 0
#     oldVal = nums[0]

#     while i<n-1:
#         i += 1
#         newVal = nums[i]
#         nums[i] = oldVal
#         oldVal = newVal
    
#     nums[0] = oldVal

if __name__ == "__main__":
     nums = [1,2,3,4,5,6,7]
     k = 3
     rotate(nums, k)
     print(nums)