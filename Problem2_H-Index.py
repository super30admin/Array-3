# Time Complexity: O(n), where n - length of input array
# Space Complexity: O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations or len(citations) == 0:
            return 0

        n = len(citations)
        arr = [0 for x in range(n + 1)]

        for c in citations:
            # Include all the citations that are greater than n in the last index
            if c >= n:
                arr[n] += 1
            # Else, add them in their corresponding index
            else:
                arr[c] += 1

        # If the running sum of num of citations is greater than or equal to the index, return that index
        rsum = 0
        for i in range(n, -1, -1):
            rsum += arr[i]
            if rsum >= i:
                return i

        return 0