# Time Complexity = O(2n)
# Space Complexity = O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        """
        [5,5,1,7,1,1,5,2,7,6]

        """
        i = 0
        j = len(height)-1
        i_bound = height[0]
        j_bound = height[-1]
        out = 0
        while i <= j:
            if i_bound <= j_bound:
                i_bound = max(height[i], i_bound)
                # print("i", i_bound, height[i])
                out += (i_bound - height[i])
                i += 1
            else:
                # print("j", j_bound, height[j])
                j_bound = max(height[j], j_bound)
                out += (j_bound - height[j])
                j -= 1

            # print(out)
        return out
