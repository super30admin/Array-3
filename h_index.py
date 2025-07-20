#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        #Bucket sort
        n = len(citations)
        count = [0] * (n + 1)
        for c in citations:
            if c > n:
                count[n] += 1
            else:
                count[c] += 1

        total = 0
        for i in range(n, -1, -1):
            total += count[i]
            if total >= i:
                return i
        return 0
