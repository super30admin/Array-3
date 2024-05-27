#Time Complexity : O(n)
#Space Complexity : O(1)
#Any problem you faced while coding this : -

#The approach is to find a pattern to change the order as per the rotation. So we first reverse the entire array to bring k element to the start of the array. Then we reverse the first k elements and then reverse the last n-k elements.

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if nums == None or len(nums) == 0:
            return 

        n = len(nums)

        if k > n:
            k = k % n

        self.reverse_list(nums, 0, n-1)
        self.reverse_list(nums, 0, k-1)
        self.reverse_list(nums, k, n-1)

    def reverse_list(self, arr, st, ed):
        while st < ed:
            temp, arr[st] = arr[st], arr[ed]
            arr[ed] = temp
            st += 1
            ed -= 1        