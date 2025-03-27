class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        left = 0
        right = len(height) -1
        leftmax = height[left]
        rightmax = height[right]
        watertrap = 0
        while left<right:
            if leftmax<rightmax:
                left += 1
                leftmax = max(leftmax,height[left])
                watertrap += max(0,leftmax-height[left])
            else:
                right -= 1
                rightmax = max(rightmax,height[right])
                watertrap +=max(0,rightmax-height[right])
        return watertrap

'''
we calculat the leftmax array 
we calculate the rightmax array 
each and every time we run the loop me will compare the wich is smaller lke this 
the time complexity is o(2n)
'''

def trap(height):
    if not height:
        return 0
    
    n = len(height)
    left_max = [0] * n
    right_max = [0] * n
    water_trapped = 0

    # Fill left_max array
    left_max[0] = height[0]
    for i in range(1, n):
        left_max[i] = max(left_max[i-1], height[i])

    # Fill right_max array
    right_max[n-1] = height[n-1]
    for i in range(n-2, -1, -1):
        right_max[i] = max(right_max[i+1], height[i])

    # Calculate trapped water
    for i in range(n):
        water_trapped += max(0, min(left_max[i], right_max[i]) - height[i])

    return water_trapped

# Example usage
height = [0,1,0,2,1,0,1,3,2,1,2,1]
print(trap(height))  # Output: 6

        