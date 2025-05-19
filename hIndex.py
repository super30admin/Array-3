class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        Approach:
        1. Use bucket sort to count how many papers have a given number of citations.
        2. Create a `bucket` array of size (n + 1), where n = total number of papers.
           - bucket[i] = number of papers with exactly i citations
           - All citations >= n are grouped in bucket[n]
        3. Traverse the bucket from the end (highest citation count) to the beginning:
           - Accumulate total papers with at least `i` citations.
           - The first `i` where total papers >= i is the h-index.

        Time Complexity: O(n) — One pass to fill the bucket, another pass to find the h-index.
        Space Complexity: O(n) — For the bucket array of size n+1.
        """
        n = len(citations)
        bucket = [0] * (n + 1)

        for c in citations:
            if c >= n:
                bucket[n] += 1
            else:
                bucket[c] += 1

        count = 0
        for i in range(n, -1, -1):
            count += bucket[i]
            if count >= i:
                return i

        return 0
