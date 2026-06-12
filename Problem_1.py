# class Solution:
#     def trap(self, height):
#         n = len(height)
#         leftWall = 0
#         rightWall = 0
#         left = 0
#         right = n - 1
#         totalWater = 0
#         while left != right:
#             leftWall = max(leftWall, height[left])
#             rightWall = max(rightWall, height[right])
#             if leftWall < rightWall:
#                 totalWater += (leftWall - height[left])
#                 left += 1
#             else:
#                 totalWater += (rightWall - height[right])
#                 right -= 1
#         return totalWater


class Solution:
    def trap(self, height):
        n = len(height)
        st = [-1]
        totalWater = 0
        for i in range(n):
            rightWall = height[i]
            while st[-1] != -1 and rightWall > height[st[-1]]:
                currBuilding = st.pop()
                leftWall = st[-1]
                if leftWall == -1:
                    break
                waterHeight = min(rightWall, height[leftWall]) - height[currBuilding]
                totalWater += (waterHeight) * (i - leftWall - 1)
            st.append(i)
        return totalWater
