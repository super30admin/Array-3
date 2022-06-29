# Tc - O(n)
# SC - O(1)
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        def bruteforce():

            result = 0
            for i in range(1, len(height) - 1):
                left_max = 0
                right_max = 0
                curr = height[i]
                for j in range(i+1):
                    if height[j] > left_max:
                        left_max = height[j]
                for k in range(i, len(height)):
                    if height[k] > right_max:
                        right_max = height[k]

                minimum_height = min(left_max, right_max)
                result += minimum_height - height[i]
            return result

        def twoPointers():

            left_max = 0
            right_max = 0
            result = 0
            lptr = 0
            rptr = len(height) - 1

            while lptr < rptr:

                if height[lptr] < height[rptr]:
                    # water can trap here
                    if height[lptr] >= left_max:
                        # if not subracting it, will overflow the water
                        left_max = height[lptr]
                    else:
                        result += left_max - height[lptr]
                    lptr += 1
                else:
                    if height[rptr] >= right_max:
                        right_max = height[rptr]
                    else:
                        result += right_max - height[rptr]
                    rptr -= 1

            return result

        return twoPointers()
