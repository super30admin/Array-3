"TC/SC: O(N)/O(1)"
class Solution:
    def trap(self, arr: List[int]) -> int:
        left = 0
        right = len(arr)-1
        leftMax = 0
        rightMax = 0
        result = 0
        while left < right:
            if arr[left] < arr[right]:
                if leftMax< arr[left]:
                    leftMax = max(arr[left],leftMax)
                else:
                    result += (leftMax - arr[left])
                left += 1
            else:
                if rightMax < arr[right]:
                    rightMax = max(arr[right],leftMax)
                else:
                    result += (rightMax - arr[right])
                right -= 1
        
        return result
