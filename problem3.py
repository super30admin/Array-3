#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this : -

#The approach is to maintain a buckets array for maintaining track of citation count and adding all irrelevant citation counts that is greater than the range of papers. We then traverse from the highest paper index to check citation count >= current paper count 

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        buckets = [0 for _ in range(n+1)]

        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1


        citation_sum = 0
        for i in reversed(range(n+1)):
            citation_sum += buckets[i]
            if citation_sum >= i:
                return i

        return 0