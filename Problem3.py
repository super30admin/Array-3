'''
Approach 1
1. Shift element by element k times
TC: O(n^2) if k is large 
SC: O(1)

Approach 2
1. Reverse the entire list
2. Reverse the numbers from index 0 to index k-1
3. Reverse the numbers from index k to index n-1. 
4. Number of steps can be greater than the length so we do k = k%n to bring down equivalent operation

TC: O(n)
SC: O(1)
'''


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Approach 1

        n = len(nums)
        k = k%n
        for _ in range(k):
            temp = nums[-1]
            for i in range(n-1,0,-1):
                nums[i] = nums[i-1]
            nums[0] = temp

        # Approach 2
        nums.reverse()
        
        k = k%n

        for i in range(k//2):
            nums[i],nums[k-1-i] = nums[k-1-i],nums[i]
            
        for i in range(k,(n+k)//2):
            nums[i],nums[n-i-1+k] = nums[n-i-1+k], nums[i]