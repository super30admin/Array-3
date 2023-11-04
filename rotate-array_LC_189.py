#TC:O(N) SC:O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums==None or len(nums)==0:
            return 
        #reverse the array
        nums[:] = nums[::-1]
        n=len(nums)
        k = k % n
        print(nums)
        #Reverse the first k elements
        nums[:k] = nums[:k][::-1]
        print(nums)
        # Reverse the last k elements
        nums[-(n-k):] = nums[-(n-k):][::-1]
        print(nums)

        
        
       
        

