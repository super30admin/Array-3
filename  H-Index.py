# Time complexity: O(n)
# Space complexity: O(n)
# Approach: Using bucket sort, put the count of numbers.
# create an array of size n+1 and traverse the citations arrays and if the value in citations is greater than n, make array of n ++, 
# else make the corresponding index + 1
# this array will indicate the number of elements of value of citations that are equal to index in array.
# now, traverse the array from backwards and keep a sum to add up the value in index.
# whenever the sum is greater than or equal to index, return index


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        if n == 0: 
            return 0
        arr = [0 for i in range(n+1)]
        for num in citations:
            if num > n:
                arr[n] += 1
            else:
                arr[num] += 1
        sum =0
        for i in range(n,-1,-1):
            sum = sum + arr[i]
            if sum >= i:
                return i
        