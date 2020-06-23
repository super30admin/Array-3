#Problem 3: h-index
#Time Complexity: O(n)
#Space Complexity: O(n)
'''
We notice that that since h index is the number such that 
h papers have more or equal than h citations, we cannot have an
H index bigger than N , since we only have N papers. This means,
that we only need to sort the elements smaller or equal to N.
Further more, we can guarantee that these elements are smaller
than N, so count sort will run at O(n). Once we sorted we can
traverse from the end and check when the number of papers exceed
the number of citations. Since we have N papers, it's impossible
that the number of papers  with more than N citations is greater than N.
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        count=[0]*(len(citations)+1)
        for citation in citations: count[min(len(citations),citation)]+=1
        sum_=0
        for i in range(len(count)-1,-1,-1):
            sum_+=count[i]
            if sum_>=i: return i
