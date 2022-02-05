# Array-3

## Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

# Time Complexity=O(n)
# Space Complexity=O(n)

class Solution:
    def trap(self, height: List[int]) -> int:
        n=len(height)
        if n==0:
            return 0
        ml=[0]*n
        mr=[0]*n
        ml[0]=height[0]
        for i in range(1,n):
            ml[i]=max(ml[i-1],height[i])
        mr[n-1]=height[n-1]
        for i in range(n-2,-1,-1):
            mr[i]=max(mr[i+1],height[i])
        r=0
        for i in range(n):
            r+=min(ml[i],mr[i])-height[i]
        return r

## Problem2 H-Index (https://leetcode.com/problems/h-index/)

# Time Complexity=O(n)
# Space Complexity=O(n)


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        helper=[0 for _ in range(len(citations)+1)]
        n=len(citations)
        for i in range(n):
            if citations[i]>n:
                helper[n]+=1
            else:
                helper[citations[i]]+=1
        papers=0
        for i in range(n,-1,-1):
            papers+=helper[i]
            if papers>=i:
                return i
        return -1
        
## Problem3  Rotate Array by K Places(https://leetcode.com/problems/rotate-array/)


# Time Complexity=O(n)
# Space Complexity=O(n)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        a = [0] * n
        for i in range(n):
            a[(i + k) % n] = nums[i]
            
        nums[:] = a