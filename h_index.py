# Time Complexity :
# O(N Log N)  - Size of the Matrix

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We sort the collectins array. Then we just need to find the position where value of the citations is lower then rest of elements changes to value of citations higher than number of remaining elements. 
#This can be done through binary search as the array is now sorted

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        low = 0
        high = len(citations) -1

        while low <= high :
            mid = low + int((high-low)/2)
            if citations[mid] >= len(citations)- mid :
                high = mid-1
            else:
                low = mid+1
        return len(citations) - low
