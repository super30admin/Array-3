# O(n) time
# O(1) space
class Solution:
	def trap(self,height: List[int]):

		l=0
		r=len(height)-1
		leftMax=0
		rightMax=0
		res=0
		while l < r:
			if height[l] <= height[r]:
				leftMax = max(leftMax,height[l])
				res += leftMax-height[l]
				l+=1
			else:
				rightMax = max(rightMax,height[r])
				res += rightMax-height[r]
				r-=1
		return res




# res=6
# leftMax=2
# rightMax=2
# res=6
#                |     
#        |       | |   | 
#.   |   | |   | | | | | |
# [0,1,0,2,1,0,1,3,2,1,2,1]
#              l r