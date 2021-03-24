"""
189. Rotate Array
Time Complexity - O(n)
Space Complexity - O(1)
So we reversed first len(nums)-k elements then reversed last k elements and revered the entire list to get output"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """ 
        k = k % len(nums)
        self.reverse(nums,0,len(nums)-k)
        self.reverse(nums,len(nums)-k,len(nums))
        self.reverse(nums,0,len(nums))
        return nums
            
    def reverse(self,array,start,end):
        end -= 1
        while(start < end):
            temp = array[start]
            array[start] = array[end]
            array[end] = temp
            start += 1
            end -= 1
            
            
        