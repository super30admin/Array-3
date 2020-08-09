class Solution:
	def trap(self, height: List[int]) -> int:
		area = 0
		if not height:
			return area
		left, right, lwall, rwall = 0,len(height)-1,0,0
		while left<=right:
			if lwall<=rwall:#process left
				if lwall>height[left]:
					area+=lwall-height[left]
				else:
					lwall=height[left]
				left+=1
			else:
				if rwall>height[right]:
					area += rwall-height[right]
				else:
					rwall = height[right]
				right-=1
		return area

#time complexity - O(n)

#space complexity - O(1)

#all test cases passed