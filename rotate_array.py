"""
Approach1: pop the element from the end and append in the front.
TC: O(k*n)
Approach2: create a new array take last k and put them in the new array and then take n-k and put it.
TC: O(n), SC: O(n)

Approach3: k =3, reverse the entire array. [1,2,3,4,5,6,7,8] -> [8,7,6,5,4,3,2,1]. By reversing the whole array we
see a pattern: revers first k elements and reverse the n-k element-> [6,7,8,1,2,3,4,5].
Another approach, first reverse the last k and n-k elements and then reverse the whole array.
TC: O(2n)
"""


class Solution:
    def arr_reverse(self, arr, lo, hi):
        while (lo <= hi):
            arr[lo], arr[hi] = arr[hi], arr[lo]
            lo += 1
            hi -= 1

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums) - 1

        # k < n, then k % n == k
        # k >= n, then k % n gives the remainder, reducing k to a valid range from 0 to n-1.
        k = (k % n)

        self.arr_reverse(nums, 0, n)
        self.arr_reverse(nums, 0, k - 1)
        self.arr_reverse(nums, k, n)
