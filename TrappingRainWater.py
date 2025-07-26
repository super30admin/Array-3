from typing import List
# class Solution:
#     def trap(self, height: List[int]) -> int:
#         # find max height which act as gurantee for lmax and rmax
#         maxid, res = 0, 0
#         n = len(height)
#         for i in range(1,len(height)):
#             if height[i] >= height[maxid]:
#                 maxid = i
#         # compute left water trapped
#         lw,l =0,0
#         while l<maxid:
#             if height[l] < lw:
#                 res+= lw-height[l]
#             else:
#                 lw = height[l]
#             l+=1
#         rw,r =0,n-1
#         # compute right water trapped
#         while r>maxid:
#             if height[r] < rw:
#                 res+= rw-height[r]
#             else:
#                 rw = height[r]
#             r-=1
#         return res

# class Solution:
#     def trap(self, height: List[int]) -> int:
#         n = len(height)
#         lw,rw,l,r,res=0,0,0,n-1,0
#         while l<=r:
#             if lw<rw:
#                 if lw>height[l]:
#                     res+=lw-height[l]
#                 else:
#                     lw = height[l]
#                 l+=1
#             else:
#                 if rw>height[r]:
#                     res+=rw-height[r]
#                 else:
#                     rw = height[r]
#                 r-=1
#         return res

class Solution:
    def trap(self, height: List[int]) -> int:
        res,st = 0,[]
        for i in range(len(height)):
            while st and height[i]>height[st[-1]]:
                popped = st.pop()
                if not st: break
                w = i-st[-1]-1
                currh = min(height[st[-1]],height[i]) - height[popped]
                res+=(w*currh)
            st.append(i)
        return res
        

        