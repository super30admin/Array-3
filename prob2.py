# Time Complexity : O(N), O(2N) as 2 for loops
# Space Complexity : O(N) for buckets array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# apply bucket sort here as you have input array of numbers in a fixed range
# maintain buckets array with one extra space for numbers outside range
# traverse buckets array from end and add to a variable sum
# if sum >= index, return index 


class Solution:

    def hIndex(citations):

        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        buckets = [0] * (n+1)

        for i in range(n):

            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
            
        res = 0
        for i in range(len(buckets) - 1, -1, -1):

            res += buckets[i]
            if res >= i:
                return i
        
        return 0