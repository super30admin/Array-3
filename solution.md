# Problem 1: Trap Rain Water
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def trap(self, height: List[int]) -> int:
              if not height or len(height)==0:
                  return 0
              n=len(height)
              leftMax=[0]*n
              rightMax=[0]*n

              leftMax[0]=0
              for i in range(1,n):
                  leftMax[i]=max(leftMax[i-1],height[i-1])

              rightMax[n-1]=0
              for i in range(n-2,0,-1):
                  rightMax[i]=max(rightMax[i+1],height[i+1])

              totalWater=0
              for i in range(n):
                  currentWater=min(leftMax[i],rightMax[i]) - height[i]
                  if currentWater<0:
                      currentWater=0
                  totalWater+=currentWater
              return totalWater

# Problem 2: H-Index
## Time Complexity :
O(nlogn)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def hIndex(self, citations: List[int]) -> int:
              if not citations or len(citations)==0:
                  return 0
              citations.sort()
              n = len(citations)
              low,high=0,n-1

              while(low<=high):
                  mid = low+(high-low)//2
                  citation = citations[mid]
                  count = n-mid
                  if citation == count:
                      return count
                  if citation<count:
                      low=mid+1
                  else:
                      high=mid-1

              return n-low


# Problem 3: Rotate Array by K Places
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No. Is this solution acceptable? 

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def rotate(self, nums: List[int], k: int) -> None:
              """
              Do not return anything, modify nums in-place instead.
              """
              n = len(nums)
              #k = k % n
              nums[:] = nums[n-k:] + nums[:n-k]
