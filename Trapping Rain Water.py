class Solution:
    def trap(self, height: List[int]) -> int:
        # Time O(n)
        # Space O(1)
        maxidx = 0
        maxx = height[0]
        n = len(height)
        for i in range(n):
            if maxx < height[i]:
                maxx = height[i]
                maxidx = i

        # Left pass till max index
        result = 0
        left = 0
        right = 0
        while (right < maxidx):
            if height[left] > height[right]:
                result += height[left] - height[right]
            else:
                left = right
            right += 1

        right = n - 1
        left = n - 1
        # Right pass till max index
        while (left > maxidx):
            if height[right] > height[left]:
                result += height[right] - height[left]
            else:
                right = left
            left -= 1

        return result

