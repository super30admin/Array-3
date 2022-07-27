# Approach: Bucket sort or counting sort
# We can use bucket sort, and to do so -> we start with
# total buckets of length n+1 where n is len of citations array
# Each index will store count of how many papers have citations that many time
# for any number greater than n, we count it all in the last bucket.
# Then we will iterate over buckets array in reverse order adding each count to a sum and as soon as index and sum value at that index becomes equal or less, we pick that as our answer.
# TC: O(N)
# SC: O(N)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        N = len(citations)
        buckets = [0] *  (N + 1)
        
        for _, c in enumerate(citations):
            if c > N:
                buckets[N] += 1
            else:
                buckets[c] += 1
        # print(buckets)
        ssum = 0
        for i in range(N, -1, -1):
            ssum += buckets[i]
            if ssum >= i:
                return i
        return -1