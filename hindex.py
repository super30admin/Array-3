# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         if not citations:
#             return 0
#         citations.sort()
#         n = len(citations)
#         print("citations is ",citations)
#         low = 0
#         high = n-1
#         while low <= high:
#             mid = low + (high-low)//2
#             print(mid)
#             val = citations[mid]
#             diff = n - mid
#             if val == diff:
#                 return val
#             elif val < diff:
#                 low = mid + 1
#             else:
#                 high = mid - 1
#         return n - low
#timecomplexity is o(n)
#spacecomplexity is o(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        arr=[0 for i in range(len(citations)+1)]
        for i in range(len(citations)):
            if citations[i]>=len(citations):
                arr[-1]+=1
            else:
                arr[citations[i]]+=1
        s=0
        for i in range(len(arr)-1,-1,-1):
            s+=arr[i]
            if s>=i:
                return i
        return 0
        
