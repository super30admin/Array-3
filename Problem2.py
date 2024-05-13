# https://leetcode.com/problems/h-index-ii/description/
# Simplified question: Atleast h papers that have each been cited at least h times.
#                              h papers: Should have >= h citations                 
#                              [This means we will be having n-h papers: which are <= h]
#                              We need to find h? (h = how many papers.)

# Approach 1: Linear Approach
# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)

        if len(citations) == 1:
            if citations[0] == 0:
                return 0
            else:
                return 1
            
        for i in range(len(citations)):     # O(n)
            if citations[i] >= n:
                return n
            else:
                n -= 1
        return 0



#---------------------------------------------------------------------------------
# APPROACH 2: Using Binary search Approach
# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left = 0 
        right = n -1

        if len(citations) == 1:
            if citations[0] == 0:
                return 0
            else: 
                return 1

        while (left <= right):
            mid = (left + right)//2
            diff = n - mid
            if citations[mid] == diff:
                return diff
            elif citations[mid] > diff:
                right = mid - 1
            else: 
                left = mid + 1
        return n - left


#---------------------------------------------------------------------------------
# https://leetcode.com/problems/h-index/

# Approach 1 :  SOrting the array, finding the h value using binary search.
# Time Complexity: O(n log n)
# Space Complexity: O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()    # O(n log n)
        n = len(citations)
        left = 0 
        right = n -1

        if len(citations) == 1:
            if citations[0] == 0:
                return 0
            else: 
                return 1

        while (left <= right):  # O(log n)
            mid = (left + right)//2
            diff = n - mid
            if citations[mid] == diff:
                return diff
            elif citations[mid] > diff:
                right = mid - 1
            else: 
                left = mid + 1
        return n - left

#---------------------------------------------------------------------------------
# Approach 2
# Time Complexity: O(n)
# Space Complexity: O(n)       
        
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        bucket = [0] * (n+1)    # space O(n)
        for citation in citations:          # O(n)
            index = min(citation, n)
            bucket[index] += 1
        
        count = 0
        for i in range(n, -1, -1):          # O(n)
            count += bucket[i]
            if count >= i:
                return i
        return 0

     


