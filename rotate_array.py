class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        replaced = 0
        n = len(nums)
        i = 0
        while replaced < n:
            start = i
            temp = nums[start]
            while True:
                next = (i + k) % n
                nums[next], temp = temp, nums[next]
                i = next
                replaced += 1

                if i == start: break
            
            if i < n:
                i += 1
        
