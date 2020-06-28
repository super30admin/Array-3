#Time Complexity :O(NLOGN)
#Space Compelxity : O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        citations.sort()
        for i in range(n):
            if citations[i] >= n-i:
                return n-i
        return 0
======================================================
#Time Complexity :O(N)
#Space Compelxity : O(N)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        temp = [0]*(len(citations)+1)
        n = len(citations)
        sum1 =0
        for i in range(len(citations)):
            if citations[i] >= n:
                temp[n]+=1
            else:
                temp[citations[i]]+=1
        print(temp)
        
        for i in range(len(temp)-1,-1,-1):
            sum1+=temp[i]
            if sum1 >= i:
                return i
        return 325678
            