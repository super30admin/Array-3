class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        n=len(citations)
        buckets=[0 for i in range(n+1)]
        sumC=0
        for el in citations:
            if el>=n:
                buckets[n]+=1
            else:
                buckets[el]+=1

        for i in range(n,-1,-1):
            sumC+=buckets[i]
            if i<=sumC:
                return i

        return 0