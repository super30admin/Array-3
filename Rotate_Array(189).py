class Solution:
    # T.C.: O(N)
    # S.C : O(1)
    # Here we first reverse the 2 parts of the array 0 to len-k and len-k to end
    # Then we reverse the entire array
    def reverse(self,nums,start,end):
        while(start<end):
            nums[start],nums[end] = nums[end],nums[start]
            start+=1
            end-=1


    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        arr_len = len(nums)
        k = k%arr_len
        self.reverse(nums,arr_len-k,arr_len-1)
        self.reverse(nums,0,arr_len-k-1)
        self.reverse(nums,0,arr_len-1)




        # arr_len = len(nums)
        # k = k%arr_len
        # temp = nums[(arr_len-k):]
        # left = arr_len - 1
        # for i in reversed(range(arr_len-k)):
        #     # nums[i+k] = nums[i]
        #     nums[left] = nums[i]
        #     left-=1
        # nums[:k] = temp
