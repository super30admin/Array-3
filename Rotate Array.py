class Solution:
    #Solution 1
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Approach: Part-by-Part Reverse
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the length of nums
        
        n = len(nums)
        k = k % n
        
        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)
        
    def reverse(self, nums, low, high):
        while low < high:
            nums[low], nums[high] = nums[high], nums[low]
            low += 1
            high -= 1
        return
    
    #Solution 2
    '''
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Approach: Brute Force; uses extra space
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of nums
        
        temp = nums.copy()
        for i in range(len(nums)):
            idx = (i - k) % len(nums)
            nums[i] = temp[idx]
    '''
    
    #Solution 3
    '''
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #Approach: Brute Force
        #Time Complexity: O(n * k)
        #Space Complexity: O(1)
        #where, n is the length of nums
        
        k %= len(nums)
        for i in range(k):
            last = nums[-1]
            for j in range(len(nums) - 1, 0, -1):
                nums[j] = nums[j-1]
            nums[0] = last
    '''