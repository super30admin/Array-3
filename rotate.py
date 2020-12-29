class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count = 0
        start = 0
        prev = nums[0]
        k%=len(nums)
        
        while count<len(nums):
            curr, prev  = start, nums[start]
            while True:
                nextIndex = (curr+k)%len(nums)
       
                
                #what now?, swap and move
                # temp = nums[nextIndex]
                # nums[nextIndex] = prev
                # prev = temp
                
                prev, nums[nextIndex] = nums[nextIndex], prev
                count+=1
                curr = nextIndex
                if start == curr:
                    break
            
            start +=1
        
        return nums 

Time: O(N)
Space: O(1)

Method : 2
    
class Solution:
def rotate(self, nums: List[int], k: int) -> None:
    k%=len(nums)
    def reverse(i, j):
        while i<j:
            nums[i], nums[j] = nums[j], nums[i]
            i+=1
            j-=1

    reverse(0, len(nums)-1)
    reverse(0, k-1)
    reverse(k, len(nums)-1)
