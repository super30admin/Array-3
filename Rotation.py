#Using modulo to determine new index
#TC: O(n)
#SC: O(n)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        output = nums[:]
        
        for i in range(0,n):
            ni = (i+k)%n
            output[ni] = nums[i]

        nums[:] = output[:] 


#Rotation solution
#TC: O(n)
#SC: O(1)
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def rotate(nums,i, j):
            while(i<j):
                nums[i],nums[j] = nums[j],nums[i]
                i = i+1
                j = j-1
            
        k = k%len(nums)
        rotate(nums,0, len(nums)-1)
        rotate(nums,0,k-1)
        rotate(nums,k,len(nums)-1)

