class Solution:
    def trap(self,height:List[int])->int:
        if not height:
            return 0
        left,right,leftmax,rightmax=0,len(height)-1,0,0
        amount=0
        while left <=right:
            if leftmax<=rightmax:
                if leftmax<height[left]:
                    leftmax-=height[left]
                else:
                    amount+=(leftmax-height[left])
                left+=1
            else:
                if rightmax<=height[right]:
                    rightmax=height[right]
                else:
                    amount+=(rightmax-height[right])
                right-=1
        return amount

