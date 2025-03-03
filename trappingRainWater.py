class Solution:
    # 2 pointers
    # TC : O(n)
    # SC: O(1)
    def trap(self, height: List[int]) -> int:
        if height is None or len(height)==0:
            return 0
        n = len(height)
        left,right = 0,n-1
        leftwall,rightwall = 0,0
        total = 0
        while left <= right:
            if leftwall <= rightwall:
                if height[left] < leftwall:
                    total += (leftwall - height[left])
                else:
                    leftwall = height[left]
                left += 1
            else:
                if height[right] < rightwall:
                    total += (rightwall - height[right])
                else:
                    rightwall = height[right]
                right -= 1
        return total
