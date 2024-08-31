#// Time Complexity : O(N) 
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        arr = [0] * (len(citations) + 1)
        for i in range(len(citations)):
            if citations[i] >= len(citations):
                arr[len(citations)] += 1
            else:
                arr[citations[i]] += 1
        temp = 0
        for i in range(len(citations),-1,-1):
            temp += arr[i]
            if temp >= i:
                return i

        return 0 

# Approach:
# we create a array and whatever hindex is greater than length of the array we put it in the last index and 
# then iterate from the last and wherever we find the breach that is out hindex
