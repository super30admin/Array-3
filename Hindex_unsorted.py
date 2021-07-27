class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """Creating another array to see which indexes are present and those indexes are the citations
        Time complexity-O(n) where n is the number of citations
        Space complexity-O(n) as using array of size equal to num of citations"""
        sum1=0
        arr=[0 for _ in range(len(citations)+1)]
        for i in citations:
            if i>=len(citations):
                arr[len(citations)]+=1
            else:
                arr[i]+=1
        for i in range(len(arr)-1, -1, -1):
            sum1+=arr[i]
            if sum1>=i:
                return i
        