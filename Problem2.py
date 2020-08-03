# Time Complexity : O(2n) = O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def rotate(self, nums, k):
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0 or k == 0 :
            return nums 
        n = len(nums)
        # **** Important ****
        # If k > n, that means rotating k=n will yeild the same array. so just take the mod and 
        # rotate the reamining times.
        # **** Important ****
        if k > n:
            k = k % n
        self.__reverse(nums, 0 , n-1) # 7 6 5 4 3 2 1  O(n)
        self.__reverse(nums, 0, k-1) # 5 6 7 4 3 2 1   O(k)
        self.__reverse(nums, k, n-1) # 5 6 7 1 2 3 4   O(n-k)
        return nums
    
    def __reverse(self, nums, i, j):
        while i <= j:
            if i < len(nums) and i >=0 and j < len(nums) and j >= 0:
                nums[i], nums[j] = nums[j], nums[i]
            i += 1 
            j -= 1 
        return 

if __name__ == "__main__":
    s = Solution()
    print(s.rotate([1,2,3,4,5,6], 11))