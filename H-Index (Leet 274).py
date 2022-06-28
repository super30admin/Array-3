'''
Check H index II - it has sorted array
'''



'''
Using sort and linear iteration
Time: O(nlogn)
Space: O(1)
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        
        citations.sort()
        
        n = len(citations)
        
        for i in range(len(citations)):
            if citations[i] >= n-i:
                return n-i
        
        return 0


'''
If it is already sorted we can perform binary search for log n time complexity. Here we will use a new sort called bucket sort.
Time: O(n)
Space: O(n)
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        
        temp = [0 for i in range(len(citations)+1)]
        
        for i in range(len(citations)):
            if citations[i] >= len(citations):
                temp[len(citations)] += 1
            else:
                temp[citations[i]] += 1
        
        res = 0
        for i in range(len(temp)-1,-1,-1):
            
            res += temp[i]
            if res >= i:
                return i