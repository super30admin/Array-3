#time complexity :O(n)
#space complexity:O(n)
#ran on leetcode: Yes
#create a array where index i denoted the number of papers who h value equals i. for the last index, it denotes papers whose h value is greater than or equal to i. Now go through this array from end to beginning while trackig a cumulative sum. If the cumulative sum>=index, then return the index
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        L=[0]*(len(citations)+1)
        for i in citations:
            if(i>=len(L)):
                L[-1]+=1
            else:
                L[i]+=1
        j=len(L)-1
        running_sum=0
        print(L)
        while(j>=0):
            running_sum+=L[j]
            if(running_sum>=j):
                return j
            j-=1
        return -1
