class Solution(object):
    def hIndex(self, citations): #T.C -> O(N) , S.C -> O(N)
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        bucket = [0] * (n + 1)

        for c in citations:
            if c >= n:
                bucket[n]+=1
            else:
                bucket[c]+=1
        sum_x=0
        for i in range(n,-1,-1):
            sum_x +=bucket[i]

            if sum_x >= i:
                return i
        return 
