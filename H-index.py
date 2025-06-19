TC: O(n^2)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        c = len(citations)
        while(c>0):
            val = 0
            for i in citations:
                if i >= c:
                    val+=1
            if val>=c:
                return c
            else:
                c=c-1

        return c
        
TC: O(nlogn)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        c = len(citations)
        citations.sort(reverse = True)
        while(c>0):
            val = 0
            for i in citations:
                if i >= c:
                    val+=1
                else:
                    break
            if val>=c:
                return c
            else:
                c=c-1

        return c
        
TC:O(n) #Counting sort - histogram
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        count_arr = [0]*(n+1)
        for i in citations:
            if i>n:
                count_arr[n]+=1
            else:
                count_arr[i]+=1
        
        print(count_arr)
        total_sum = 0
        for c in range(len(count_arr)-1,-1,-1):
            total_sum+=count_arr[c]
            if total_sum>=c:
                return c
        return -1
