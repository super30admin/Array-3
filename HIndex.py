# Tc - O(n)
# SC - O(n)
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """

        n = len(citations)
        count = [0] * (n+1)
        for i in range(1, len(citations) + 1):
            index = min(n, citations[i-1])
            count[index] += 1

        rsum = 0

        for key in range(len(count) - 1, -1, -1):
            rsum += count[key]
            # number of papers with citations >= key(h)
            # once number of citations becomes greater than or equal to h return the number
            # since the other n-h paper need to be lesser than key
            if rsum >= key:
                return key
