# Time Complexity: O(n), be being the length of citations array

# Space Complexity:O(n) auxillary space to store the counts

# Approach:Construct an array of count where we store how many papers are cited of at least that count index. We then traverse this arrayfrom last index and start calculating the sum of papers for each citation number. The first number where sum of all counts with citations becomes greater than the citation number will be our h index.

# Did it run on Leetcode:Yes

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        count = [0] * (len(citations) + 1)
        amount = 0
        for i in citations:
            count[min(i, len(citations))] += 1
        for i in range(len(count) - 1, 0, -1):
            amount += count[i]
            if amount >= i:
                return i
        return 0

