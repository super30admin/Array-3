# tc O(n), sc O(1).
res = 0
left, right = 0, len(height) - 1
maxleft, maxright = height[left], height[right]

while left < right:
    if maxleft <= maxright:
        left += 1
        maxleft = max(maxleft, height[left])
        res += maxleft - height[left]
    else:
        right -= 1
        maxright = max(maxright, height[right])
        res += maxright - height[right]

return res