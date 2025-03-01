#space: O(1)
#time: O(n)
#approach, rotate the whole array, rotate the first k elements and then the remaining elements
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0:
            return 
        k = k%len(nums)
        self.reverse(0,len(nums)-1, nums)
        self.reverse(0,k-1, nums)
        self.reverse(k,len(nums) -1 , nums)
        return 

    def reverse(self, left,right,arr):
        while left < right:
            arr[left], arr[right] = arr[right],arr[left]
            left +=1
            right -=1
        return arr
        
