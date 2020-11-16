""" Time : O(n)
    Space : O(n)
    Leetcode : Yes
    Explanation : Use bucket sort to get a dictionary such that last bucket has the count of all 
    the elements greater than the size of the nums. Count backwards from the bucket to get the first index where
    cumulative sum is greater than the index.
"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        dic = {}
        for c in citations:
            if c > len(citations):
                dic[len(citations)] = dic.get(len(citations),0)+1
            else:
                dic[c] = dic.get(c,0)+1
        
        print(dic)
        count = 0
        for i in range(len(citations),-1,-1):
            count += dic.get(i,0)
            if count>=i:
                return i
        return 0
        
                
            