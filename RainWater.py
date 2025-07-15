# Time Complexity: O(n)
# Sapce Complexity: O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0

        i, j = 0, len(height) - 1
        leftmax, rightmax = 0, 0
        count = 0

        while i < j:
            leftmax = max(leftmax, height[i])
            rightmax = max(rightmax, height[j])

            if leftmax < rightmax:
                count += leftmax - height[i]
                i += 1
            else:
                count += rightmax - height[j]
                j -= 1

        return count