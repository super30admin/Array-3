# Time Complexity : Add - O(2n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Use Bucket sort.
2. create an arrat of length of citation +1, if a citation is present at index we mark it as one,
3. If citation is > the length of arry, put it in last index
4. In reverse order start counting the citations, the crossover points gives the hindex
'''


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        if not citations or len(citations) < 1:
            return 0
        
        arr = [0]*(len(citations)+1)  
        for i in range(len(citations)):
            if citations[i] < len(arr):
                arr[citations[i]] += 1
            else:
                arr[-1] += 1
                
        print(arr)
        
        rsum = 0
        i = len(arr) - 1
        
        while i>=0:
            rsum += arr[i]
            if rsum >= i:
                return i
            i -= 1

            
        
        
        