#Using bukcet sort to solve this problem as taught in class
#Time COmplexity: O(n)
#Space complexity: O(n)
def hIndex(self, citations: List[int]) -> int:
        buckets = [0 for i in range(len(citations)+1)]
        for i in range(len(citations)):
            if citations[i] >= len(citations):
                buckets[len(citations)] = buckets[len(citations)] + 1
            else:
                buckets[citations[i]] = buckets[citations[i]] + 1
        sum = 0
        for i in range(len(citations),-1,-1):
            sum = sum + buckets[i]
            if sum >= i:
                return i
        return 64