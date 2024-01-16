# TC: O(N)
# SC: O(len(CITATIONS))

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        arr=[0 for i in range(0,len(citations)+1)]

        for c in citations:
            if c>len(citations):
                arr[len(citations)]+=1
            else:
                arr[c]+=1
        print(arr)
        sum1=0
        for i in range(len(citations),-1,-1):
            sum1=sum1+arr[i]
            if sum1>=i:
                return i
        
        return 0


        # max1=max(citations)
        # arr=[0 for i in range(max1+1)]
        # for i in range(0,len(citations)):
        #     for j in range(0,citations[i]+1):
        #         arr[j]+=1

        # for i in range(0,len(arr)):
        #     if arr[i]<i:
        #         break
        #     if i==len(arr)-1 and arr[i]>=i:
        #         return i

        # if i<1:
        #     return 0

        # return i-1 

        