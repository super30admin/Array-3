# sort the array
# create another array for number of papers which have no of citations greater than or equal to the current.
# find the h-index.
# this method uses extra space.
# time complexity - O(nlogn) # nlogn - sorting, traversals - O(n)
# space complexity - O(n) # number of papers array

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort() # sort the array - O(nlogn)
        n = len(citations)
        
        npapers = []
        for i in range(n): # O(n)
            npapers.append(n-i)
        
        for i in range(n): #O(n)
            if npapers[i]<=citations[i]:
                return npapers[i]
        return 0
    

# assign the citations to the bucket.
# return the index of the bucket where the value of the bucket is less than the index.
# Time complexity - O(n)  # any citations greater than the length of index 
# Space complexity - O(n) # buckets for sorting
# did this code run on leetcode? - yes
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)  # length of citations
        buckets = [0] * (n+1)   # bucket
        
        # O(n) create buckets
        for i in range(n):
            citation = citations[i]
            buckets[min(n, citation)] += 1
        
        # select the right bucket index and return 
        sumi = 0
        for i in range(n, -1, -1):
            sumi += buckets[i]
            if sumi >= i:
                return i
        return 0
        
        