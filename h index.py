#TC: O(n)
#SC: O(n)
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n=len(citations)
        buckets=[0 for i in range(n+1)]
        for i in range(n):
            if citations[i]>=n:
                buckets[n]+=1
            else:
                buckets[citations[i]]+=1
        sum1=0
        for i in range(n,-1,-1):
            sum1+=buckets[i]
            if sum1>=i: return i
        return 0

#we can sort the array and find the h index using diff=n-i as the brutforce solution
#TC: O(n*n)
#SC: O(1)
#and if we do binary search TC is O(nlogn)
# Time Complexity: O(nlog(n))
# Space Complexity: O(1)
# class Solution:
    # def hIndex(self, citations: List[int]) -> int:
    #     citations.sort()
    #     n=len(citations)
    #     for i in range(len(citations)):
    #         diff=n-i
    #         if citations[i]>=diff:
    #             return diff
    #     return 0