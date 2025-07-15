"""
Use two pointers (left, right) to scan from both ends of the array
Track tallest walls seen so far from left (left_max) and right (right_max)
At each step, trap water by comparing current height to the lower of left_max or right_max, and move the smaller side inward
"""
"""
Time Complexity : O(n) - One pass
Space Complexity : O(1) - No auxillary space
"""


class trappingRain:
    def trap(self, height: list[int]) -> int:
        if not height:
            return 0

        left, right = 0, len(height) - 1
        left_max, right_max = 0, 0
        water = 0

        while left < right:
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    water += left_max - height[left]
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    water += right_max - height[right]
                right -= 1

        return water

if __name__ == "__main__":
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    obj = trappingRain()
    result = obj.trap(height)
    print(result)  
