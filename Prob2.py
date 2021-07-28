class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        #bucket sort concept: sort only range of n elements
        # time  and space complexity: O(n)
        n = len(citations)
        buckets = [0 for i in xrange(n+1)]
        for citation in citations:
            if citation>n:
                buckets[n] += 1
            else:
                buckets[citation] += 1
        sumOfCitations = 0
        for i in xrange(n,-1,-1):
            sumOfCitations += buckets[i]
            if sumOfCitations >= i:
                return i
        
        #overall time complexity: O(nlogn)
    #     citations.sort()
    #     #linear search: O(n)
    #     # for i in xrange(n):
    #     #     diff = n-i
    #     #     if citations[i] >= diff:
    #     #         return diff
    #     # return 0
    # #Binary search: O(log n)
    #     n = len(citations)
    #     l,h = 0,n-1
    #     while l<=h:
    #         mid = (l+h)/2
    #         if n-mid == citations[mid]:
    #             return n-mid
    #         elif n-mid > citations[mid]:
    #             l = mid+1
    #         else:
    #             h = mid - 1
    #     return n-l
            
