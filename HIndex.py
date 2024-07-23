# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def hIndex(self, citations):
        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        buckets = [0] * (n + 1)

        # Count the number of citations for each paper
        for c in citations:
            if c >= n: # If the count of the citations exceeds the number of papers
                buckets[n] += 1
            else:
                buckets[c] += 1

        count = 0
        for i in range(n, -1, -1):
            count += buckets[i]
            if count >= i: # If the current count is greater than or equal to the current number of
                           # papers
                return i
        return 0

# Example 1
sol = Solution()
print("Example 1: ", sol.hIndex([3, 0, 6, 1, 5]))  # Output: 3

# Example 2
print("Example 2: ", sol.hIndex([1, 3, 1]))  # Output: 1

# Example 3
print("Example 3: ", sol.hIndex([0, 0, 4, 4]))