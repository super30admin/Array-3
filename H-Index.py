""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        buckets = [0] * (n+1)
        for i in citations:
            if i >= n:
                buckets[n] += 1
            else:
                buckets[i] += 1
        papercount = 0
        for i in range(len(buckets)-1, -1, -1):
            papercount += buckets[i]
            if papercount >= i:
                return i
        return 0


""""// Time Complexity : O(nlog(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
    # def hIndex(self, citations: List[int]) -> int:
    #     citations.sort()
    #     n=len(citations)
    #     for i in range(len(citations)):
    #         diff=n-i
    #         if citations[i]>=diff:
    #             return diff
    #     return 0