class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # Approach 1
        # Time Complexity: O(nlogn + n)
        # Space Complexity: O(1)
        # citations.sort()
        # counter = len(citations)
        # for i in range(len(citations)):
        #     if citations[i] >= counter:
        #         return counter
        #     counter -= 1
        # return 0

        # Approach 2
        # Time O(n)
        # Space O(n)
        bucket = [0 for i in range(len(citations)+1)]

        for i in citations:
            if i > len(citations):
                bucket[-1] += 1
            else:
                bucket[i] += 1
        print(bucket)
        currsum = 0
        for i in range(len(bucket)-1, -1, -1):
            currsum += bucket[i]
            if currsum >= i:
                return i
        return 1

