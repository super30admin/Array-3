class Solution:
    '''
    Refer leetcode solutions explanation
    '''
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        papers = [0]*( n+1 )
        for c in citations:
            papers[min(n,c)] += 1
        
        k = n
        s = papers[n]
        while s < k:
            k -= 1  
            s+= papers[k] # s = the sum of all counts with citation >= k 
                          # paper[k] -> count of all the papers with that citation
        return k 
        
        
    def hIndexComparisionSort(self, citations: List[int]) -> int:
        citations.sort(reverse= True)
        i = 0 
        ans = 0 
        while i < len(citations):
            if citations[i] > i:
                ans += 1
            i += 1
        return ans
