class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #Time Complexity : O(LogN)
        #Space Complexit : O(1)
        # n = len(citations)
        # for i in range(0,n):
        #     diff = n - i
        #     if(citations[i]>=diff):
        #         return diff
        # return 0

        #Time Complexity : O(LogN)
        #Space Complexit : O(1)
        n = len(citations)
        low,high=0,n-1
        while(low<=high):
            mid=low+(high-low)//2
            diff=n-mid
            if(citations[mid]==diff):
                return diff
            elif(citations[mid]<diff):
                low = mid+1
            else:
                high = mid-1
        #At the end of the loop:low is at the first index where citations[low] >= n - low.The h-index is exactly n - low, as it correctly counts the papers meeting the criteria.
        return n-low