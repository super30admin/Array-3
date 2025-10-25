class Solution:
    # The time is O(nlogn) as we can sort the entire citations element array and then determine the h index, if that is less than equal to citations at that index we can return.
    # space is O(1) if the sorting algo doesn't use extra memory.
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n = len(citations)
        for i in range(n):
            hIndex = n - i
            if hIndex <= citations[i]:
                return hIndex
        return 0

    # The time is O(n) as we use bucket sort. The idea behind this is we don't have to sort the entire citations array. Then iterate through the back and whenever there is a flip thats the result
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        bucketSort = [0] * (n + 1)

        for i in range(n):
            if citations[i] >= len(bucketSort):
                bucketSort[len(bucketSort) - 1] += 1
            else:
                bucketSort[citations[i]] += 1
        curr = 0
        for i in range(len(bucketSort) - 1, -1, -1):
            curr += bucketSort[i]
            if curr >= i:
                return i

        return 0