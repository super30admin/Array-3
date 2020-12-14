#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        buckets = [0] * (n+1)
        #get counts of all citations
        for c in citations:
            #if citations are greater than length of the array, then just add count to the citations of the length to the array
            if c > n:
                buckets[n] += 1
            else:
                buckets[c] += 1

        total = 0
        #iterate through the array from the end
        for i in range(n, -1, -1):
            #get total papers
            total += buckets[i]
            #if number of papers become greater than equal to the citations(i) them return
            if total >= i:
                return i
        return 0
