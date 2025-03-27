# Time O(2n)
# Space O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        maxH = 0
        maxId = 0
        n = len(height)
        for i in range(n):
            if maxH < height[i]:
                maxH = height[i]
                maxId = i
        leftWall = 0
        result = 0
        for i in range(maxId):
            if height[i] > leftWall:
                leftWall = height[i]
            if height[i] < leftWall:
                result += leftWall - height[i]
        rightWall = 0
        for i in range(n-1, maxId, -1):
            if height[i] > rightWall:
                rightWall = height[i]
            if height[i] < rightWall:
                result += rightWall - height[i]
        return result

# Time O(n)
# Space O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left = 0
        right = n-1
        leftWall = 0
        rightWall = 0
        result = 0
        while left <= right:
            if leftWall <= rightWall:
                if height[left] >= leftWall:
                    leftWall = height[left]
                else:
                    result += leftWall - height[left]
                left += 1
            else:
                if height[right] >= rightWall:
                    rightWall = height[right]
                else :
                    result += rightWall - height[right]
                right -= 1
        
        return result

# Time O(n)
# Space O(n)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        stack = [-1]
        i = 0
        result = 0
        while i < n :
            while stack[-1] != -1 and height[i] > height[stack[-1]]:
                popped = stack.pop()
                if stack[-1] == -1: continue
                w = i - stack[-1] - 1
                result += (min(height[stack[-1]], height[i])  - height[popped]) * w
            stack.append(i)
            i += 1
        return result