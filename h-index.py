'''
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Do counting sort to get the number of elements in each bucket. After getting the number of elements iterate
through the list from the right to left computing the running Sum. Once the sum >= index[i] we reached the position to
return. If any element in the array is greater than the largest element in the array just change that element to the
largest element in the array.
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0

        n = len(citations)

        buckets = [0 for j in range(n + 1)]

        # counting sort
        for c in citations:
            if c > n:
                c = n
            buckets[c] += 1

        runningSum = 0

        # o to n
        index = len(buckets) - 1  # start from right to left

        # calculate running Sum
        while index >= 0:
            runningSum += buckets[index]

            if index <= runningSum:
                return index

            index -= 1

        return 0