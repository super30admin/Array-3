class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        array = [0 for _ in range(len(citations)+1)]
        for i in range(len(citations)):
            if citations[i]>=len(array):
                array[-1]+=1
            else:
                array[citations[i]]+=1
        total = 0
        i = len(array)-1
        while i>=0:
            total+=array[i]
            if total>=i:
                return i
            i-=1
        return 0

#time complexity = O(2n) to be exact
#space complexity = O(n)

#all test cases passed