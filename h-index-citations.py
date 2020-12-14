class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # if len(citations)==0:
        #       return 0
        # # if len(citations)==1:
        # #     return 1
        # citations.sort(reverse=False)
        # # print(citations)
        # for i in range(len(citations)):
        #     diff=len(citations)-i
        #     if diff<=citations[i]:
        #         return diff
        # return 0
        # the other way round will not work here ex:[2] --> sort citations in desc order
        # time-O(nlogn) space-O(1)

        # bucket sort
        #         time -O(n), o(n)
        sum = 0
        n = len(citations)
        bucket = [0] * (n + 1)
        for i in range(n):
            if citations[i] < n:
                bucket[citations[i]] += 1
            else:
                bucket[-1] += 1
        for i in range(n, -1, -1):
            sum += bucket[i]
            if sum >= i:
                return i
