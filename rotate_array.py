# tc :O(n), sc : O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        """
        if len(nums) <=1:
            return
        def reverse_arr(arr, st, en):
            start = st
            end = en
            while start <= end:
                arr[start], arr[end] = arr[end], arr[start]
                start += 1
                end -= 1
        
        n = len(nums) -1
        reverse_arr(nums, 0, n)
        #print(nums)
        if k>=(n+1):
            k = k%(n+1)
        reverse_arr(nums, 0 , k-1 )
        #print(nums)
        reverse_arr(nums, k, n)
        #print(nums)
        
