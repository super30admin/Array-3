#time complexity:O(n)
#SC:O(1)
#Algo://At each step I need to find the leftmax and rightmax. Then I need to pick minimum of them and add their difference between them and the corresponding left or right element and add it to the count. This is because the water can be trapped upto the height of the minimum of two pillars.
class Solution:
    def trap(self, height: List[int]) -> int:
        l=0
        r=len(height)-1
        leftmax=0
        rightmax=0
        if len(height)==0:
            return 0
        amount=0
        while l<r:
            leftmax=max(height[l],leftmax)
            rightmax=max(height[r],rightmax)
            if leftmax<rightmax:
                amount+=leftmax-height[l]
                l+=1
            else:
                amount+=rightmax-height[r]
                r-=1
        return amount 
        
        
