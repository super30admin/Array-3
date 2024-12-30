# Approach:
# To calculate the h-index, sort the citations array in descending order. 
# Iterate through the sorted array to find the maximum h such that the researcher has at least h papers with at least h citations.
# Use a counter to compare paper counts against their citation counts.

# Time Complexity: O(n log n) due to sorting.
# Space Complexity: O(1) since no extra space is used apart from variables.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # Step 1: Sort the citations array in descending order
        citations.sort(reverse=True)

        # Step 2: Initialize h-index to 0
        h_index = 0

        # Step 3: Iterate through the sorted citations array
        for i, citation in enumerate(citations):
            # Check if the current citation count is at least i + 1
            if citation >= i + 1:
                h_index = i + 1  # Update h-index
            else:
                break  # Stop as soon as the condition is not met
        
        return h_index
