'''
TC: O(n)
SC: O(n)

Intuition:

- h indx can be at most the size of the array
- Any number >= length, sorting order doesnt matter
- sort h indexes upto the lenght of array
- use count / bucket sort for sorting
- Use cumulative sum from end, if the sum of numbers is greater or equal to idx then return
'''
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        clen = len(citations)
        if not clen:
            return 0
        
        buckets = [0 for _ in range(clen + 1)]
        
        for c in citations:
            if c < clen:
                buckets[c] += 1
            else:
                buckets[clen] += 1
        
        sums = 0
        
        for idx in range(clen, -1, -1):
            sums += buckets[idx]
            if sums >= idx:
                return idx
        
        return -1