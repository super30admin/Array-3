#  Time Complexity : O(N)  
#  Space Complexity : O(N)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: We use an extra array to store the count at the citation mentioned in the citation array. For a citation that is greater than the citations array we add an extra count at the index representing the nth element. Then we traverse in the reverse direction and sum all the counts in the new array. As soon as the sum is greater than the index which means that more than that number of citations are present in the array then we return that value.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # TC:O(n) SC: O(n)
        n = len(citations)
        buckets = [0] * (n + 1)

        for el in citations:
            if el > n:
                buckets[n] += 1
            else:
                buckets[el] += 1
        
        sum = 0
        for i in range(n, -1, -1):
            sum += buckets[i]
            if sum >= i:
                return i
        return -1