class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #use bucket sort to sort the elements in O(n), and traverse from the end of the sorted list, whenever number of citations >= index , we found H-index
        #TC-O(n),SC-O(n)
        n=len(citations)
        count=[0 for i in range(n+1)]
        for i in citations:
            if i >= n:
                count[n]+=1
            else:
                count[i]+=1
        s=0
        for i in range(n,-1,-1):
            s+=count[i]
            if s>=i:
                return i
        return -1
