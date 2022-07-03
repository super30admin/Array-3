'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    def trap(self, height: List[int]) -> int:
        maxH = 0
        maxHIdx = 0 
        for i in range(len(height)):
            if(maxH<=height[i]):
                maxH = height[i]
                maxHIdx = i

            
        slow = 0
        ans = 0
        for i in range(0,maxHIdx+1):
            if(height[slow]>height[i]):
                print(ans)
                ans+=(height[slow]-height[i])
            else:
                slow = i
        print("==")
        slow = len(height)-1
        
        for i in range(len(height)-1,maxHIdx-1,-1):
            if(height[slow]>height[i]):
                print(ans)
                ans+=(height[slow]-height[i])
            else:
                slow = i
        return ans