# TC: O(N)
# SC: O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0

        result = 0
        left, right = 0, len(height) - 1
        left_max, right_max = height[left], height[right]

        while left < right:
            left_max = max(left_max, height[left])
            right_max = max(right_max, height[right])

            if left_max <= right_max:
                result += left_max - height[left]
                left += 1
            else:
                result += right_max - height[right]
                right -= 1

        return result


        # result=0
        # for i in height:
        #     if i !=0:
        #         left=right=i
        #         break
        
        # while left<len(height):
        #     while right<len(height) and height[right]<=height[left]:
        #         right+=1

        #     cur=left
        #     while cur<right:
        #         result=result+(height[left]-height[cur])
        #         print(height[left]-height[cur],end=" ")
        #         cur+=1
        #     left=right
        #     print(str(left)+" "+str(right))
        
        # return result
        