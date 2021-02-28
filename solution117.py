#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations)==0:
            return 0
        n=len(citations)
        bucket=[0 for i in range(n+2)]              #create a bucket array of size one greater than citations
        for i in range(n):                          #if the value in cittions is greater than size of bucket increment last value of bucket
            if citations[i]>=n:
                bucket[n]+=1
            else:                                   #else increment the respective value of citation within the bucket
                bucket[citations[i]]+=1
        s=0                                         #variable to hold the sum from backwards of the array
        for i in reversed(range(n+1)):              #if the sum is greater than index at any point, return index.
            s+=bucket[i]
            if s>=i:
                return i
        return 0