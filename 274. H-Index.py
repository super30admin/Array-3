#bucket sort for this
# we create a bucket with size of no of papers +1
# mark the buckets with +1 for each papers citation count
# traverse from back to check if the no. of citations >= no. of pprs in bucket sort
#Space: O(n)
# time: O(n)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        bucket= [0]* (len(citations)+1)
        for i in range(len(citations)):
            if citations[i] < len(bucket):
                bucket[citations[i]] +=1
            else:
                bucket[-1] +=1
        summ=0
        for i in range(len(bucket)-1,-1,-1):
            summ= summ+ bucket[i]
            if summ >= i:
                return i
        return 0
        
