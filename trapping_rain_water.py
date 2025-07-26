# Time complexity: O(n)
# Space complexity: O(1)
def trap(height):
    if not height: return 0
    left, right = 0, len(height) - 1
    max_left, max_right = height[left], height[right]
    water = 0
    while left < right:
        if max_left < max_right:
            left += 1
            if height[left] < max_left: water += max_left - height[left]
            else: max_left = height[left]
        else:
            right -= 1
            if height[right] < max_right: water += max_right - height[right]
            else: max_right = height[right]
    return water
