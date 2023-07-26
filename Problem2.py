class Solution(object):
    def hIndex(self, citations):
        """
        Time complexity - O(n)
        Space complexity - O(n)

        :type citations: List[int]
        :rtype: int
        """
        if citations is None or len(citations) == 0:  # Check if the citations list is empty or None.
            return 0

        # Get the number of papers (the length of the citations list).
        n = len(citations)

        # Step 1: Create an array (buckets) to store the counts of citations for each possible value.
        buckets = [0] * (n + 1)

        # Step 2: Count the occurrences of each citation value and store it in the corresponding bucket.
        for citation in citations:
            if citation >= n:
                buckets[n] += 1
            else:
                buckets[citation] += 1

        # Step 3: Traverse the buckets in reverse order to find the H-Index.
        sum_citations = 0
        for i in range(n, -1, -1):
            sum_citations += buckets[i]
            if sum_citations >= i:
                return i  # The current index 'i' is the H-Index.

        # If no H-Index is found within the loop, return 0.
        return 0
