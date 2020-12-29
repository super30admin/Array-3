class Solution:
    def trap(self, height: List[int]) -> int:
        leftHighest = [0]*len(height)
        rightHighest = [0]*len(height)
        
        curr = 0
        sumArray = [0]*len(height)
        for i in range(len(leftHighest)):
            leftHighest[i] = curr
            curr = max(curr, height[i])
        curr = 0
        result = 0
        for i in range(len(rightHighest)-1, -1, -1):
            rightHighest[i] = curr
            sumArray[i] = max(min(leftHighest[i], rightHighest[i])-height[i],0)
            result+=sumArray[i]
            curr = max(curr, height[i])

        return result
Time: O(N)
Space: O(N)
            
