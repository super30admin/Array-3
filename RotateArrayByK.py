class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        T: O(N)
        S: O(1)
        Using (reverse sections of the array) technique
        """
        def rev(i, j):
            while i<j:
                nums[i], nums[j] = nums[j], nums[i]
                i+=1
                j-=1
            
        if k>len(nums):
            k = k%len(nums)
            
        # Logic
        rev(0, len(nums)-1) # Reversing entire array
        rev(0, k-1) # Reversing 0 to k
        rev(k, len(nums)-1) # Reversing k to end
        
        return nums