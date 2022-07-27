class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # Time Complexity: O(n)
        # Space Complexity: O(1)


        if nums==None or len(nums)==0: return nums
        def rev(nums,s,e):
            s=s
            e=e
            while s<=e:
                nums[s],nums[e]=nums[e],nums[s]
                s+=1
                e-=1
        n=len(nums)
        k=k%n
        rev(nums,0,n-1)
        rev(nums,0,k-1)
        rev(nums,k,n-1) 


# TC: O(n)
#SC: O(n)
# class Solution(object):
#     def rotate(self, nums, k):
#         """
#         :type nums: List[int]
#         :type k: int
#         :rtype: None Do not return anything, modify nums in-place instead.
#         """
#         result=[0 for i in range(len(nums))]
#         for i in range(len(nums)):
#             if i+k<len(nums):
#                 result[i+k]=nums[i]
#             else:
#                 j=0
#                 j=(i+k)%len(nums)
#                 result[j]=nums[i]
#         k=0
#         for i in result:
#             nums[k]=i
#             k+=1