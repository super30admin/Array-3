
#Time Complexity :Nlog(N)
#Space Complexity: O(1)
def hIndex(self, citations: List[int]) -> int:
    if not citations:
        return 0
    citations.sort()
    ##print(citations)
    # print([5,4,3,2,1])
    n = len(citations)
    for i in range(n):
        diff = n - i
        if citations[i] >= diff:
            return diff
    return 0

#Time Complexity :o(N)
#Space Complexity: O(N)
def hIndex(self, citations: List[int]) -> int:
    if not citations:
        return 0
    n = len(citations)
    bucketSort = [0] * (n + 1)
    for i in citations:
        if i >= n:
            bucketSort[n] += 1
        else:
            bucketSort[i] += 1

    # print(bucketSort)
    result = 0
    for i in range(n, -1, -1):
        result += bucketSort[i]
        if result >= i:
            return i

    return 0