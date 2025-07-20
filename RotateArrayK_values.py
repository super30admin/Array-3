#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution(object):
    def reverse(self,arr,l,r):
            while l < r:
                temp = arr[l]
                arr[l] = arr[r]
                arr[r] = temp
                l += 1
                r -= 1
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # reverse teh array
        # reverse first k elemnets
        # reverse the K + 1 to n elements
        n = len(nums)

        k = k % n #(no.of rotations, incase of K > length of array)
        self.reverse(nums,0,n-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,n-1)
    