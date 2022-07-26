# Time Complexity: O(nlog(n))
# Space Complexity: O(1)
class Solution:
    # def hIndex(self, citations: List[int]) -> int:
    #     citations.sort()
    #     n=len(citations)
    #     for i in range(len(citations)):
    #         diff=n-i
    #         if citations[i]>=diff:
    #             return diff
    #     return 0
# Time Complexity: O(n)
# Space Complexity: O(n)
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        dp=[0]*(n+1)
        for i in citations:
            if i>n: dp[n]+=1
            else: dp[i]+=1
        s=0
        for i in range(n,-1,-1):
            s=s+dp[i]
            if s>=i: return i