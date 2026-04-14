# problem 3 

# https://leetcode.com/problems/rotate-array/description/


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k%n # if more than count we can reduce 
        start_idx = 0 
        count = 0
        while count < n:
            curr_idx = start_idx 
            prev_val = nums[start_idx]
            while True:
                next_idx = (curr_idx+k) % n
                nums[next_idx],prev_val = prev_val,nums[next_idx]
                curr_idx = next_idx 
                count+=1
                if start_idx == curr_idx:
                    break
            start_idx+=1 
                
        