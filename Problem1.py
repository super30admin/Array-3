# Approach 1: 1. We added 2 pointers one towards the 0th index of the list and one pointer at the end of the list.
#             and named them as left pointer (lp) and right pointer (rp)
#             2. Intially I considered left wall (lw) and right wall(rw) values as 0
#             3. It also initializes the result variable to 0, which will store the total amount of trapped water.
#             4. The method then enters a while loop that continues as long as the left pointer (lp) is less than or equal to the right pointer (rp).
#                   -> Inside the loop, it compares the heights of the left wall (lw) and the right wall (rw):
#                           -> If the height of the left wall is less than or equal to the height of the right wall, it processes the left side:
#                                -> If the height of the left wall (lw) is less than the height of the current bar (height[lp]), it updates the left wall height to the height of the current bar.
#                           -> Otherwise, it calculates the trapped water on the left side and adds it to the result.
#                           -> The left pointer (lp) is then incremented.
#                   -> If the height of the right wall is less than the height of the left wall, it processes the right side similarly.
#             5. Finally, once the while loop finishes, the method returns the total amount of trapped water stored in the result variable.
# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n <= 2:
            return 0  # Cannot trap water with less than 3 elements

        lw = 0
        rw = 0
        lp = 0
        rp = n-1
        result = 0

        while lp <= rp:
            if lw <= rw:
                if lw < height[lp]:
                    lw = height[lp]
                else:
                    result += lw - height[lp]
                lp += 1
            else:
                if rw < height[rp]:
                    rw = height[rp]
                else:
                    result += rw - height[rp]
                rp -= 1
        return result

#-----------------------------------------------------------------------------------------------------------
# Approach 2: Find the maximum element. and compare it to the elemets 
#               1. which are present to the left considering it(maximum element) as a right wall. 
#               2. which are present to the right considering it(maximum element) as a right wall.
#             Followed the steps similar to Approach 1(from step 4)
# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lp = 0  # left pointer
        lw = 0  # left wall
        rp = n-1   # right pointer 
        rw = 0  # right wall
        maxi = 0    # Maximum number in a list
        result = 0
        for i in range(n):      # O(n)
            if height[i] > maxi:
                maxi = height[i]
        while lp <= rp:         # O(n)
            if lw != maxi:
                if lw <= height[lp]:
                    lw = height[lp]
                else: 
                    result += lw-height[lp]
                lp += 1
            else: 
                lw = maxi
                if rw <= height[rp]:
                    rw = height[rp]
                else: 
                    result += rw-height[rp]
                rp -= 1
        return result
                

        

            
            
    