#  time complexity is o(n), where n is the size of the input
#  space complexity is o(n)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        bsa = [0 for i in range(n+1)]
        
        #bucket sort
        for i in citations:
            if(i > n):
                bsa[n] += 1
            else:
                bsa[i] += 1
        # print(bsa)
        res = 0
        for i in range(len(bsa)-1, -1, -1):
            res += bsa[i]
            if(res >= i):
                return i
        return 0
            
        # 1 1 3
        # 3 2 1
        
        # 0 1 3 5 6
        # 5 4 3 2 1
        
        
        # time o(nlog(n))
#         citations.sort()
#         n = len(citations)
#         for i in range(n):
#             if(citations[i] >= n - i):
#                 return n - i
#         return 0
                
            
        
        
        