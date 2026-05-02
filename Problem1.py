# https://leetcode.com/problems/trapping-rain-water/description/
# TC: O(3n)
# SC: O(2n)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lw = [0] * n
        rw = [0] * n

        for i in range(1, n):
            lw[i] = max(lw[i-1], height[i-1])

        for j in range(n-2, 0, -1):
            rw[j] = max(rw[j+1], height[j+1])

        re = 0

        for k in range(0, n):
            re += max(0, min(lw[k], rw[k]) - height[k])

        return re

# TC: O(2n)
# SC: O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        re = 0
        maxi = 0
        maxId = -1
        for i in range(n):
            if maxi < height[i]:
                maxi = max(maxi, height[i])
                maxId = i

        lw, l = height[0], 1
        while l < maxId:
            if lw > height[l]:
                re += lw - height[l]
            else:
                lw = height[l]
            l += 1

        rw, r = height[n-1], n-2
        while r > maxId:
            if rw > height[r]:
                re += rw - height[r]
            else:
                rw = height[r]
            r -= 1

        return re

# TC: O(n)
# SC: O(1)    
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        l, lw = 1, height[0]
        r, rw = n-2, height[n-1]
        re = 0

        while l <= r:
            if rw > lw:
                if lw > height[l]:
                    re += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if rw > height[r]:
                    re += rw - height[r]
                else:
                    rw = height[r]
                r -= 1

        return re
    
# Stack implementation
# TC: O(2n)
# SC: O(n)
class Solution:
    def trap(self, height: List[int]) -> int:
        st = []
        re = 0
        n = len(height)

        for i in range(n):
            while st and height[i] > height[st[-1]]:
                popped = st.pop()

                if st:
                    effHeight = min(height[st[-1]], height[i])
                    width = i - st[-1] - 1

                    re += (effHeight - height[popped]) * width

            st.append(i)

        return re