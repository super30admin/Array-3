# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

Time: O(n) for finding max, then O(n-h) for left pass and O(n-h) for right pass so total O(n)
Space: O(1)

Find the max height and index. left pass to find the gaps knowing that somewhere the right wall that is higher than current left wall exists. Same logic for right pass.

class Solution:
    def trap(self, height: List[int]) -> int:
        # find max height
        maxH = float('-inf')
        max_idx = 0
        area = 0
        for i in range(len(height)):
            if height[i] > maxH:
                maxH = height[i]
                max_idx = i

        # left -> max
        leftmax = 0
        l = 0
        while l < max_idx:
            l += 1
            if height[l] >= height[leftmax]:
                leftmax = l
            area += (height[leftmax]-height[l])

        # max <- right
        rightmax = len(height)-1
        r = len(height)-1
        while r > max_idx:
            r -= 1
            if height[r] >= height[rightmax]:
                rightmax = r
            area += (height[rightmax] - height[r])
        
        return area


## Problem2 H-Index (https://leetcode.com/problems/h-index/)

finding h index through bucket sort/counting. When h >= n is fulfilled, hindex is found

Time: O(n)
Space: O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        bucket = [0] * (n+1)
        totalCitations = 0

        for i in range(len(citations)): # O(n)
            cite = citations[i]
            if cite >= len(citations):
                bucket[-1] += 1
                continue
            bucket[cite] += 1

        for i in range(n,0,-1): # O(n)
            # bucket[citations] >= idx a.k.a h >= n
            totalCitations += bucket[i] 
            if totalCitations >= i:
                return i
        return 0




## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)

Time: O(n)
Space: O(1)

Fill temp array to satisfy the logic, and then copy back the elements from temp to nums

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k >= len(nums):
            k = k % len(nums)

        temp = [0]*len(nums)

        # 1,2,3,4,5,6,7 => (0+3)%7=3 (1+3)%7=4 (2+3)%7=5 
        
        for i in range(len(temp)):
            temp[(i+k)%len(nums)] = nums[i]
        
        for i in range(len(nums)):
            nums[i] = temp[i]
        




