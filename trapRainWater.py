
#As taught in class, using 4 pointeers to solve this problem
#Time Complexity: O(n)
#Space Complexity: O(1)
def trap(self, height: List[int]) -> int:
    if height is None or len(height) == 0:
        return
    lw =height[0]
    rw =height[len(height)-1]
    l = 0
    r = len(height) - 1
    res = 0
    while l <= r:
        if lw <= rw:
            if height[l] < lw:
                res = res + lw - height[l] 
            else:
                lw = height[l]
            l = l + 1
        else:
            if height[r] < rw:
                res = res + rw - height[r] 
            else:
                rw = height[r]
            r = r - 1
    return res