#Time Complexity -> O(n)
#Space Complexity -> O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Take the modulus so if k=len of nums then we do not need to rotate
        k=k%len(nums)
        
        #Helper function to reverse the array
        def helper(l,r):
            while l<r:
                nums[l],nums[r]=nums[r],nums[l]
                l+=1
                r-=1
        
        #1st reverse the whole array
        helper(0,len(nums)-1)
        #2nd reverse the k elemnts
        helper(0,k-1)
        #Reverse the rest of the k elements
        helper(k,len(nums)-1)