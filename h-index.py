# Time Complexity:O(n)
# Space Omplexity:O(n)
class Solution:
    def hIndex(self, citations):
        #         Check for null citation if return 0

        if not citations:
            return 0

        n = len(citations)
        # Define bucket with +1 extra size than of the length of citation
        bucket = [0] * (n + 1)
        #         We will iterate over the citation and current number is greater than the size
        #         of the citation then we will update counter of last bucket index and if not then
        #         current number location counter will be updated
        for i in range(n):
            if citations[i] >= n:
                bucket[n] += 1
            else:
                bucket[citations[i]] += 1
        #         Now we will be having the bucket array ready and now we will iterate from back and
        #         update the sum with current value and if at any point if sum is greater than the index
        #         of the array we will return that index and it will be maximum of values that is h-index
        sum_val = 0
        for i in range(n, -1, -1):
            sum_val += bucket[i]
            if sum_val >= i:
                return i
