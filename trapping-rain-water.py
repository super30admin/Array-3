# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    # def trap(self, height: List[int]) -> int:
    #     slow=0
    #     fast=1
    #     n=len(height)
    #     curTrap=0
    #     result=0
    #     #1st pass from left to right 
    #     while fast<n:
    #         if height[fast]<height[slow]:
    #             curTrap+=height[slow]-height[fast]
    #         else:
    #             result+=curTrap
    #             curTrap=0
    #             slow=fast
    #         fast+=1
    #     peak=slow
    #     slow=n-1
    #     fast=n-2
    #     curTrap=0
    #     # 2nd pass from right to left
    #     while fast>=peak:
    #         if height[fast]<height[slow]:
    #             curTrap+=height[slow]-height[fast]
    #         else:
    #             result+=curTrap
    #             curTrap=0
    #             slow=fast
    #         fast-=1     
    #     return result
# Time Complexity: O(n)
# Space Complexity: O(1)
# Single pass
    def trap(self, height: List[int]) -> int:
        n=len(height)
        l=0
        r=n-1
        result=0
        lw=0
        rw=0
        while l<=r:
            if lw<=rw:
                if height[l]<lw:
                    result+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if height[r]<rw:
                    result+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return result
        
        