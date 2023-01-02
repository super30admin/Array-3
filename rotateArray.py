'''
We can take reversal appraoch for the this problem

Time Complexity --> O(n)
Space Complexity --> O(1)

'''
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        def reverse_list(nums, s, e):
            while s<e:
                tmp = nums[s]
                nums[s] = nums[e]
                nums[e] = tmp
                s+=1
                e-=1
        



        n = len(nums)
        k=k%n
        reverse_list(nums, 0, len(nums)-1)
        #Now reverse first k elemnts
        reverse_list(nums, 0, k-1)
        #Now revese the list from k to n-k elements
        reverse_list(nums, k, n-1)


        print(nums)
        
