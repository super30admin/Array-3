# BRUTE FORCE APPROACH
  # Popping the last element and inserting it at the first position (0th index).
# Time Complexity: O(n*k)
# Space Complexity: O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in range(k):  # O(k)
            last_ele = nums.pop(len(nums)-1)    # O(1) -> popping
            nums.insert(0,last_ele)    # O(n) -> inserting 

#---------------------------------------------------------------------------------
# APPROACH 2:
  # Reversing the whole array
  # Reversing first k elements (nums[:k])
  # Reversing the next n-k elements (nums[k:])
# Time Complexity: O(n) + O(k) + O(n-k) = O(2n)
# Space Complexity: O(1)
 
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n= len(nums)
        k = k% n

        if k == n:
            return
        nums.reverse()          # O(n)
        nums[:k] = reversed(nums[:k])   # O(k)
        nums[k:] = reversed(nums[k:])   # O(n-k)


#---------------------------------------------------------------------------------
# APPROACH 3:
  # Reversing first n-k elements 
  # Reversing the remaing k elements 
  # Reversing the whole array
# Time Complexity: O(n-k) + O(k) + O(n) = O(2n) => O(n)
# Space Complexity: O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k % n

        if k == 0 or k == n:
            return
       
        nums[:n-k] = reversed(nums[:n-k]) # O(n-k)
        nums[n-k:] = reversed(nums[n-k:]) # O(k)
        nums.reverse() # O(n)

#---------------------------------------------------------------------------------
# APPROACH 4:
  # Same as Approach 2 but without using in-built methods and functions 
# Time Complexity:  O(n) + O(k) + O(n-k) = O(2n) =>O(n)
# Space Complexity: O(1)


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k %n 

        if n == k or k == 0: 
            return
        
        def reverse(nums, first_idx, last_idx):     
            while first_idx <= last_idx:
                swap(nums, first_idx, last_idx)
                last_idx -= 1
                first_idx += 1
        
        
        def swap(nums, first_idx, last_idx):
            nums[first_idx], nums[last_idx] = nums[last_idx], nums[first_idx]  # O(1)

        reverse(nums, 0, n-1)   # O(n)
        reverse(nums, 0, k-1)   # O(k)
        reverse(nums, k, n-1)   #O(n-k)
