## Problem2 H-Index (https://leetcode.com/problems/h-index/)
# -------------------------------------------------------------------------
# Complexity Analysis:
# -------------------------------------------------------------------------
# Time Complexity: O(N)
# - Step 1: Iterating over the 'citations' array of size N to populate 
#   the frequency bucket array takes O(N) time.
# - Step 2: Iterating backwards from N down to 0 over the bucket array 
#   takes O(N) time.
# - Total Time Complexity: O(N) + O(N) = O(N).
#
# Space Complexity: O(N)
# - We allocate an extra bucket array 'citationCount' of size (N + 1) to 
#   store citation frequencies.
# - Total Space Complexity: O(N).
# -------------------------------------------------------------------------

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        
        # citationCount[i] stores the number of papers with exactly 'i' citations.
        # Size is (n + 1) because any paper with citations >= n can be capped at n.
        citationCount = [0] * (n + 1)

        # Step 1: Populate the frequency bucket array.
        for c in citations:
            # Cap the citation count at 'n' since the h-index cannot exceed total papers 'n'.
            idx = min(c, n)
            citationCount[idx] += 1
        
        total = 0
        # Step 2: Iterate backwards from the maximum possible h-index (n) down to 0.
        for h in range(n, -1, -1):
            # The first 'h' where accumulated papers (total + citationCount[h]) >= 'h'
            # is the maximum valid h-index.
            if total + citationCount[h] >= h:
                return h
            
            # Keep a running sum of papers with at least 'h' citations.
            total += citationCount[h]
        
        return 0








        #-------------------------------------------------------------------------
        # Complexity Analysis:
        # -------------------------------------------------------------------------
        # Time Complexity: O(N^2)
        # - In the worst-case scenario (e.g., when the answer is 0 or low), the outer 
        #   'while' loop runs up to N times (where N is the length of citations).
        # - For each iteration of 'n', the inner 'for' loop iterates over all N elements.
        # - Thus, total time complexity is O(N * N) = O(N^2).
        #
        # Space Complexity: O(1)
        # - The algorithm only uses a few primitive variables ('n', 'num', 'i') for 
        #   iteration and counting.
        # - No extra data structures are allocated, so space complexity is constant O(1).
        # -------------------------------------------------------------------------
        n = len(citations)
        
        # Check all possible h-index values starting from the maximum possible value (n) down to 1.
        while n > 0:
            num = 0  # Tracks how many papers have at least 'n' citations
            
            # Count the number of papers with citations >= current candidate 'n'
            for i in range(len(citations)):
                if citations[i] >= n:
                    num += 1
                
                # As soon as we find 'n' papers with at least 'n' citations,
                # 'n' is valid and is guaranteed to be the maximum possible h-index.
                if num == n:
                    return n
            
            # If fewer than 'n' papers have >= 'n' citations, try the next lower possible h-index.
            n -= 1
            
        # If no positive h-index satisfies the condition, the h-index is 0.
        return 0