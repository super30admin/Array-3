'''
Time Complexity - O(2n), We iterate 2 arrays of length n at least once
Space Complexity - O(n). We create an additional array for buckets

Works on leetcode
'''


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #create a buckets array
        n = len(citations)
        #create n+1 buckets
        buckets = [0 for i in range(n+1)]
        for citation in citations:
            #if citation value is greater than number of elements, increase count of last index
            if citation >= n:
                buckets[n]+=1
            #else increase the count of respective index
            else:
                buckets[citation] += 1
        sum = 0
        for i in range(n, -1, -1):
            #add the counts, until the sum become equal or greater than the index
            sum+=buckets[i]
            if sum >= i:
            #return the index where this occurs
                return i

        return 9808
