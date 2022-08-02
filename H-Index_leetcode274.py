class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # Bucket sort
        # TC - O(n) SC - O(n)
        n = len(citations)
        papers = [0 for _ in range(n + 1)]
        for i in range(n):
            if citations[i] >= n:
                papers[n] += 1
            else:
                papers[citations[i]] += 1
        h = 0
        for i in range(n, -1, -1):
            h += papers[i]
            if h >= i:
                return i

    '''
        # Sort TC - O(nlog(n)) SC - O(1)
        citations.sort(reverse = True)
        #citations = sorted(citations, reverse = True)
        i = 0
        n = len(citations)
        while i < n:
            if citations[i] > i:
                i += 1
            else:
                return i
        return i
    '''

