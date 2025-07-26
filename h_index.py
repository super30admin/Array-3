# Time complexity: O(n log n) due to sorting
# Space complexity: O(1) if sorting in-place, O(n) otherwise
def hIndex(citations):
    citations.sort(reverse=True)
    h_index = 0
    for i, citation in enumerate(citations):
        h_index = max(h_index, min(citation, i + 1))
    return h_index
