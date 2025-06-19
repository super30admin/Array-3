#https://leetcode.com/problems/trapping-rain-water/
TC: O(n) => 3 pass solution
SC: O(n)
#Intuition : Water gets trapped when there is left and right wall. We find the maximum in the list 
# and make it act as left&right wall
class Solution:
    def trap(self, height: List[int]) -> int:
        maxi = 0
        wall = 0 
        for i in range(0,len(height)):
            if height[i] > maxi:
                maxi=height[i]
                wall = i
        
        left_max = 0
        output = 0
        left_ptr = 1
        while(left_ptr<wall):
            if height[left_max]>height[left_ptr]:
                output+=height[left_max]-height[left_ptr]
            else:
                left_max=left_ptr
            left_ptr +=1
        
        right_max = len(height)-1
        right_ptr = right_max-1
        while(right_ptr>wall):
            if height[right_ptr]<height[right_max]:
                output+=height[right_max]-height[right_ptr]
            else:
                right_max=right_ptr
            
            right_ptr -=1
        
        return output
        
        
#Single pass solution - Instead finding max and assuming as right/left wall. Calculating on the fly
#TC: O(n)
#SC: O(n)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)-1
        lw = 0
        lp = lw+1
        rw = n
        rp = rw -1
        output = 0
        while(lp<=rp):
            if height[lw]<= height[rw]:
                if height[lp] < height[lw]:
                    output += height[lw]-height[lp]
                else:
                    lw = lp
                lp = lp+1
            else:
                if height[rp]<height[rw]:
                    output += height[rw]-height[rp]
                else:
                    rw = rp
                rp= rp -1
        
        return output
