#All TC on leetcode passed


class Solution:
    def hIndex(self, citations: List[int]) -> int:

         #Here we use binary search. If at any point we find our mid citation == (n-midIdx) then we return the diff (n-midIdx). If mid citation is lesser than diff then we move our left pointer else right pointer. If we find a mid citation with val greater than diff then we need to confirm that its the first lowest occurrence, hence for this we move our right pointer to mid-1
        #Here (n-i) denotes no. of paper with citation = citation[i]

        #Time complexity - O(logn)
        #Space complexity - O(1)
        n= len(citations)
        l=0
        r=n-1

        while l<=r:
            mid = (l+r)//2
            diff = n - mid

            if citations[mid]==diff:
                return diff
            elif citations[mid]<diff:
                l = mid+1
            else:
                r = mid-1

        return n-l

#---------------------------------------OR------------------------------------------
        
        #Here for every ith entry we check if (n-i) is lesser than or equal to cur citation. If yes then we return (n-i) as h index.
        #Here (n-i) denotes no. of paper with citation = citation[i]

        #Time complexity - O(n)
        #Space complexity - O(1)
        n = len(citations)
        for i in range(n):
            if n-i<=citations[i]:
                return n-i
        
        return 0  #for [0] case we shd return 0 