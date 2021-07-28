'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 274. H-Index


# https://leetcode.com/problems/h-index/

#-----------------
# Time Complexity: 
#-----------------
# O(N): Need N traversals to find count of each citation. Need another N 
#       traversal from behind to check which element's cumuluative sum crosses
#       corresponding citations value. 
#------------------
# Space Complexity: 
#------------------
# O(N) - Need bucket of size N+1

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        if n == 0:
            return 0
        
        buckets = [0 for i in range(n+1)]
        
        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
        
        cumul_sum = 0
        
        for i in range(n, -1, -1):
            cumul_sum += buckets[i]
            if cumul_sum >= i:
                return i
        #Error if program reaches here.
        return -1