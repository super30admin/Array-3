"""
// Time Complexity : O(nlogn) n is length of shorter array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is to construct the h array of size len(citations) + 1 which consists of count of papers having citations equal to the current index except the last index where we can add if there are more citations than current index
Iterate over the N to 0 array, 
    update the total with current count from h_aray
    return when the total > i
Else return 0
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #Old method - nlogn(suboptimal)
        # citations.sort()
        # n = len(citations)
        # lo,hi = 0,n - 1
        # while lo <= hi:
        #     mid = (lo + hi) // 2
        #     citation = citations[mid]
        #     count = n - mid
        #     if citation == count:
        #         return count
        #     elif citation < n - mid:
        #         lo = mid + 1
        #     else:
        #         hi = mid - 1
        # return n - lo

        #Method2 - optimal - O(N)
        N = len(citations)
        h_array = [0]*(N+1)
        """
        [3,0,6,1,5] -> [1,1,0,1,0,1,1]
        """
        
        for c in citations:
            if c > N:
                h_array[N]+=1
            else:
                h_array[c]+=1
        
        total = 0
        for i in range(N,-1,-1):
            total+=h_array[i]
            if total >= i:
                return i
        return 0