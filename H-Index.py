class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        H-Index
        Time complexity : nlogn
        Space complexity : O(1)
        """
        citations.sort()
        self.final = 0
        for i,num in enumerate(citations):
            if num >= len(citations) - i:
                self.final += 1
        return self.final