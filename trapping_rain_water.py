"""
Approach1: Find the max height.
Take a left pointer (current height) that starts from the beginning of array. Also define a variable left wall. if the
current height is less than left wall height, then water can be trapped. If the current height is greater than left wall
height, then water cannot be trapped. And the current height can be left wall for the next elements.
once left pointers reach the max height, we need to traverse the array from right since after this there won't be any
bigger left wall. For this define a variable right wall and do the same.
TC: O(2n), SC: O(1)
note: to trap water there should be a bigger right wall, by finding the max we make sure of that.

Approach2: using 2 pointers.
TC: O(n)

Todo: using stacks
"""


class Solution_approach2:
    def trap(self, height: List[int]) -> int:

        n = len(height)

        ans = 0
        lw, rw = height[0], height[n - 1]
        l, r = 0, n - 1

        while l <= r:
            # have right left wall
            if rw > lw:
                if height[l] < lw:
                    ans += lw - height[l]
                else:
                    lw = height[l]
                l += 1

            else:
                if height[r] < rw:
                    ans += rw - height[r]
                else:
                    rw = height[r]
                r -= 1

        return ans


class Solution_approach1:
    def trap(self, height: List[int]) -> int:

        n = len(height)
        max_h = float("-inf")
        max_id = -1

        for idx, he in enumerate(height):
            if he > max_h:
                max_h = he
                max_id = idx
        ans = 0
        lw = height[0]
        l = 0
        while l < max_id:
            if height[l] < lw:
                ans += lw - height[l]
            else:
                lw = height[l]
            l += 1

        r = n - 1
        rw = height[n-1]
        while r > max_id:
            if height[r] < rw:
                ans += rw - height[r]
            else:
                rw = height[r]
            r -= 1

        return ans


