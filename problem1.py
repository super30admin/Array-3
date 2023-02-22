#time O(N)
#space O(N)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        k=k%len(nums)
        def reverse(nums,s,e):
            while s<e:
                temp=nums[s]
                nums[s]=nums[e]
                nums[e]=temp
                s+=1
                e-=1
        reverse(nums,0,len(nums)-1)
        reverse(nums,0,k-1)
        reverse(nums,k,len(nums)-1)
        
                    
        