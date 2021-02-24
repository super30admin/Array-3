# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        buckets = [0 for _ in range(len(citations)+1)]
        
        # count how many papers have 0, 1, 2, 3, 4, 5 citations
        # 6 citations and above, just dump in bucket[5]
        
        for c in citations:
            # if within range, put in bucket of it's index
            if(c<=len(citations)):
                buckets[c] += 1
            # if out of range, dump in last bucket
            else:
                buckets[-1] += 1
                
        print(buckets)
        sum = 0
        # iterate over the array to find where the sum greater than or equal to the index
        # that index would be the h-index
        for i in range(len(citations),-1, -1):
            sum += buckets[i]
            if sum >=  i:
                return i