'''
Time Complexity = O(n)

Space Complexity =O(2n)

The key of the solution of the finding the max from the right, and max from the left, and subtract the min of those two arrays to the value.
'''

class Solution:
    def trap(self, height: List[int]) -> int:

        left_arr = []
        right_arr = []
        left_max = 0
        right_max = 0
        rain_water = 0

        for i in range(len(height)):

            if(height[i]>left_max):
                left_max = height[i]
            left_arr.append(left_max)

            if(height[len(height)-1-i]>right_max):
                right_max = height[len(height)-1-i]

            right_arr.append(right_max)

        right_arr = right_arr[::-1]

        for i in range(len(height)):

            rain_water+=min(left_arr[i], right_arr[i])-height[i]

        return rain_water




