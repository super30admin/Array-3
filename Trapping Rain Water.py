# time complexity is o(n), where n is the size of the input
# space complexity is o(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lw = 0
        rw = 0
        l = 0
        r = n - 1
        res = 0
        while(l <= r):
            if(lw <= rw):
                if(height[l] < lw):
                    res += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if(height[r] < rw):
                    res += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return res
            
                    
        
        
        
        
#         using peak
        # n = len(height)
        # slow = 0
        # fast = 1
        # res = 0
        # capArea = 0
        # #forward pass
        # while(fast < n):
        #     if(height[slow] > height[fast]):
        #         capArea += height[slow] - height[fast]
        #     else:
        #         res += capArea
        #         slow = fast
        #         capArea = 0
        #     fast += 1
        # peak = slow    
        # slow = n-1
        # fast = n-2
        # capArea = 0
        # #backward pass
        # while(fast >= peak):
        #     if(height[slow] >= height[fast]):
        #         capArea += height[slow] - height[fast]
        #     else:
        #         res += capArea
        #         slow = fast
        #         capArea = 0
        #     fast -= 1
        # return res
        
#         without peak
#         n = len(height)
#         slow = 0
#         fast = 1
#         res = 0
#         capArea = 0
#         #forward pass
#         while(fast < n):
#             if(height[slow] > height[fast]):
#                 capArea += height[slow] - height[fast]
#             else:
#                 res += capArea
#                 slow = fast
#                 capArea = 0
#             fast += 1
#         # peak = slow    
#         slow = n-1
#         fast = n-2
#         capArea = 0
#         #backward pass
#         while(fast >= 0):
#             if(height[slow] >= height[fast]):
#                 capArea += height[slow] - height[fast]
#             else:
#                 res += capArea
#                 slow = fast
#                 capArea = 0
#             fast -= 1
#         return res
        
                
                
            
                
                
        