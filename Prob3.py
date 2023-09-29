
#For H-index find max h such that -> 1. There n elements with citations greater than or equal to h
        #       2. n-h elemnts with citations lesser than or equal to h.
        #Since, here array is sorted, we don't have to worry about 1st condition.
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #Method 1 - Linear - O(n)
        # n=len(citations)
        # for i in range(n):
        #     diff=n-i#n-h elements
        #     if diff<=citations[i]: #n-h elements with citations lesser than or equal to h.
        #         return diff
        # return 0

        #method 2 - Binary Search - O(logn)

        #Same can be done using bin search too
        n = len(citations)
        l = 0
        r = n - 1
        while l <= r:
            mid = l + (r - l) // 2
            diff=n-mid #n-h calculation
            if citations[mid] == diff: #we need n-h lesser or equal to h, this is the equal case
                return n - mid
            elif citations[mid] > diff: #if curr>n-h move right
                r = mid - 1
            else: #else move left
                l = mid + 1
        return n - l #in the end low will have the h so return n-l



        

