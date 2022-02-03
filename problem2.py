#Time Complexity = O(n)
#Space Complexity = O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if(citations ==None or len(citations)==0):
            return -1
        arr = [0 for i in range(len(citations)+1)]
        
        for i in citations:
            if(i>=len(citations)):
                arr[len(citations)]+=1
            else:
                arr[i]+=1
        count = len(arr)-1
        s = 0
        for i in arr[::-1]:
            s+=i
            if(s>=count):
                return count
            count-=1
        return -1
        