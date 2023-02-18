class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # TC: O(nlogn)
        # SC: O(1)
        # First we sort the array such that it is a increasing number of citations
        # Here the thinking is that
        # at at any given index, the papers including current & after the current
        # will have atleast citations[i]
        # So at whichever index the citations become
        # equal to or greater than number of remainng papers(including current)
        # that index would be the h-index
        if (citations is None) or (len(citations)==0):
            return 0

        citations.sort()
        n = len(citations)
        low = 0
        high = n - 1

        while low<=high:
            mid = low + ((high-low)//2)
            h = citations[mid]

            if n-mid == h:
                return n-mid
            elif n-mid>h:
                low = mid+1
            else:
                high = mid-1

        # We couldn't get an exact match, so the prev number to the current low will satisfy the given condition
        return n-low