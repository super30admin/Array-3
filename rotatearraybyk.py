class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # tc : o(n), sc : O(1)
        # rotate arra by k steps : first reverse the rigth part of the array, then left part and then whole array
        # right_index is k
        # left arr = n-k

        n = len(nums)

        if k > n :
            k = k%n
            
        left_index = n-k

        nums[:n-k] = self.reverse(nums[:n-k])
        nums[n-k:n] = self.reverse(nums[n-k:n])
        nums = self.reverse(nums)

    def reverse (self, arr):
        i = 0
        j = len(arr)-1

        while (i < j ):
            arr[i] , arr[j] = arr[j], arr[i]
            i +=1
            j -=1

        return arr