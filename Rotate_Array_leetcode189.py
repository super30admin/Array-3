class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Use extra space O(n)
        n = len(nums)
        a = [0 for _ in range(n)]
        for i in range(n):
            a[(i + k) % n] = nums[i]
        nums[:] = a

    '''
        # Brute Force
        # TC - O(n*k) - Time limit exceeded
        n = len(nums)
        for j in range(k):
            shift = nums[-1]
            for i in range(n):
                nums[i],shift = shift,nums[i]
    '''

    '''
    # reverse in place TC O(n) SC O(1)
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # example [100, 300, 150, 200, -10] reverse completely= [-10, 200, 150, 300, 100] 
        # reverse till k and then remaining final = [150,200, -10, 100, 300]

        n= len(nums)
        k = k%n
        self.reverseFunc(nums,0,n-1)
        self.reverseFunc(nums,0,k-1)
        self.reverseFunc(nums,k,n-1)

        # OR
        # example [100, 300, 150, 200, -10] 
        # reverse till n-k and then remaining reverse = [300, 100, -10, 200, 150]
        # reverse completely = [150,200, -10, 100, 300] 

    def reverseFunc(self, nums, left, right):
        while left < right:
            nums[left],nums[right] = nums[right],nums[left]
            left += 1
            right-= 1
    '''
