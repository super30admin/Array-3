class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Observe the patteern, 3 reverses are happening -> 
        #1. full reverse 0 to n-1
        #2. then 0 to k-1 is a reverse
        #3. then reverse from k till n-1
        #TC - O(n)
        if not nums or len(nums)==0:
            return 
        n=len(nums)

        k=k%n

        def reverse(l,r):
            while l<r:
                nums[l],nums[r]=nums[r],nums[l]
                l += 1
                r -= 1
        reverse(0,n-1)
        reverse(0,k-1)
        reverse(k,n-1)
