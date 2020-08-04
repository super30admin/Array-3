# keep two left and right
# initialize left at 0 and right at the last location of the height array
# left wall and right wall are initialized to 0.
# move until the left and right pointer cross eachother.
# if left wall is less than the right wall. 
# compare the height of left wall and height of left pointer location.
# add the difference to the result if the left wall is less than the height of left pointer location.
# repeat for the right wall.
# Time complexity - O(n)
# Space complexity - O(1)
# did this code run on github - yes
class Solution:
    def trap(self, height: List[int]) -> int:
        # find the length
        n = len(height)
        
        lw, rw = 0, 0   # initial height of the elevation walls (these are not the indices).
        l, r = 0, n-1   # indices on the elevation map.
        
        res=0
        while l<=r:
            # if left wall height is less than the right wall height
            if lw<=rw:
                # check if the left wall is less than the height of left pointer.
                if lw<=height[l]:
                    lw = height[l]
                else:   # if the left wall is greater than the height of left pointer, add the difference to the result.
                    # water can be trapped here.
                    res += lw-height[l]
                l+=1
            else:   # if the height of the right wall is less than the height of the left wall. 
                # check if the right wall is less than the height of right pointer.
                if rw<=height[r]:
                    rw = height[r]
                else:
                    res += rw-height[r] # water can be trapped here.
                r-=1
        
        return res
                

# time complexity - O(n)
# space complexity - O(n)
# by maintaining an array of left max and right maximum.
# at each position, select the minimum of left and right max. 
# subtract that from the height.
class Solution:
    def trap(self, height: List[int]) -> int:
        maxes = []
        
        # track the previous height from the left. 
        prevh = 0
        for h in height:                        # traverse from the left
            maxes.append(prevh)
            prevh = max(prevh, h)
        
        # update the maxes with the minimum of left and right height
        prevh = 0
        for h in range(len(height)-1, -1, -1): # traverse from the right
            maxes[h] = min(maxes[h], prevh)
            prevh = max(prevh, height[h])
            
        res = 0
        for h in range(len(height)):
            if maxes[h] > height[h]:
                res += maxes[h] - height[h]
        
        return res
        