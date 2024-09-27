# time complexity - O(n)
# Space complexity - O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # citations.sort()
        # bucket sort the values
        # since the potential value for an h index is limited by the len
        # of the array the values greater than the len of the array 
        # dont matter and can be added to the last index
        n = len(citations)
        buckets = [0]*(n+ 1)
        for each in citations:
            if each >= n:
                buckets[-1] += 1
            else:
                buckets[each] += 1
        # once we bucket sort we check the sum of each bucket from the end
        # of the aray if the sum matches the index thats our h-index
        # or the one where sum is lower thats our h-index
        ans = 0 
        for i in range(n,-1,-1):
            ans += buckets[i]
            if ans >= i:
                return i
        return -1
