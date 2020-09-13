#Time complexity: O(n)
#Space complexity: O(1)
#Works on leetcode: yes
#Approach: Firt we reverse the whole array, then reverse from start to k and lastly we reverse from k to end of the 
#reversed array. 

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(start, end):
            while start<end:
                nums[start], nums[end] = nums[end], nums[start]
                start +=1
                end -=1
        
        k,n = k%len(nums), len(nums)
        if k:
            reverse(0,n-1)
            reverse(0,k-1)
            reverse(k,n-1)