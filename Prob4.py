class Solution:
    def hIndex(self, citations: List[int]) -> int:

        #Method 1 - Now, here, since it isn't in order -> 1. sort it out and then do bin search (H-index 2 solution) - O(nlogn) TC

        #Method 2 - Bucket sort - TC and SC O(n)
        #Any element greater than len of the array doesn't bother us, so just count it in the nth bucket else put it in it's own bucket
        n=len(citations)
        buckets=[0 for _ in range(n+1)] 

        for cit in citations:
            if cit>=n:
                buckets[n]+=1 #putting things into nth bucket.
            else:
                buckets[cit]+=1 #else put it in it's own bucket
        sum=0
        for i in reversed(range(n+1)): #then, traverse from nth bucket till 0th and keep adding.
            sum+=buckets[i] 
            if i<=sum: #till sum is greater than or equal to i.
                return i