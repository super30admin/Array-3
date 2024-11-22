# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name:  Trapping Rain Water

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        result = 0
        st = []

        for i in range(n):
            while st and height[i] > height[st[-1]]:
                popped = st.pop()
                if not st:
                    break
                distance = i - st[-1] - 1 
                bounded_height = min(height[i], height[st[-1]]) - height[popped]
                result += distance * bounded_height 
            st.append(i)
        return result


        # result = 0
        # n = len(height)
        # l, lw = 0, 0

        # maxId = -1
        # mx = 0

        # # Find the index of the highest bar
        # for i in range(n):
        #     if mx < height[i]:
        #         mx = height[i]
        #         maxId = i

        # # Traverse from left to maxId
        # while l < maxId:
        #     if lw > height[l]:
        #         result += lw - height[l]
        #     else:
        #         lw = height[l]
        #     l += 1

        # # Traverse from right to maxId
        # r, rw = n - 1, 0
        # while r > maxId:
        #     if rw > height[r]:
        #         result += rw - height[r]
        #     else:
        #         rw = height[r]  # Fixed this line to update rw
        #     r -= 1

        # return result
