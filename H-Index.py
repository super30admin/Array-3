#time: O(nlogn)
#space= O(1)

#brute force
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations=sorted(citations)
        i=0
        n=len(citations)
        while(i<len(citations)):
            diff=n-i
            if(diff<=citations[i]):
                return diff
            i+=1
        return 0
                