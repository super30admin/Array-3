#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
#If k==n  then we are not rotating anything and if it's greater
#If k>n For example, rotating an array of length n = 7 by k = 9 is the same as rotating it by k = 9 % 7 = 2
        if(k>=n):
            k = k%n
        def reverse(l,r):
            while(l<r):
                nums[l],nums[r]=nums[r],nums[l]
                l+=1
                r-=1
            return nums
        reverse(0,n-1)
        reverse(0,k-1)
        reverse(k,n-1)

        #Optimized Solution
        # nums[:] = nums[-k%n:]+nums[:-k%n]   



