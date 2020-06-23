#Time Complexity:O(n)
#Space complexity :O(1)
#Leetcode:yes
#Algo:
# Counting sort is used to store the count of occurrance of each index in the citations array(as a hashmap). All those indices whose values are greater than or equal to the value of the citations array length are added to the last index of the count array. Then this temp array is iterated from behind and if I find any index whose count value is equal to or greater than the current index value, then that index would become the h index.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        bucket=[0]*(len(citations)+1)   
        n=len(citations)
        total=0
        for c in citations:
                if c>=n:
                    bucket[n]+=1
                else:
                    bucket[c]+=1
        if (bucket[n] >= n): return n
        for i in range(n,0,-1):
            total+=bucket[i]
            if total>=i:
                return i
        return 0
