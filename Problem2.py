#I solved the problem by first sorting the list of citations in descending order. The goal is to find the highest index h such that the researcher has published h papers with at least h citations each. By iterating through the sorted list and comparing the citation count j to the index i, I identify the point where the number of citations is less than or equal to the index. At this point, the highest valid h-index is found and returned. If the loop completes without finding such a point, the length of the citations list is returned, as it indicates all papers have at least as many citations as their position in the sorted list. The time complexity of this solution is O(nlogn) due to the sorting step, and the space complexity is O(1) as it uses a constant amount of additional space.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort(reverse=True)
        for i,j in enumerate(citations):
            if i>=j:
                return i
        return len(citations)

        