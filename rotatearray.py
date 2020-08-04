# to shift the elements, k steps to the right
# rotate the entire array
# rotate the first k elements and then the remaining elements separately.
# time complexity - O(n)
# space complexity - O(1)
# did this code run on leetcode? - yes

# nums[::-1] creates a new list # not in-place algorithm
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)   # length of nums
        k %= n
        self.rev(nums, 0, n-1)
        self.rev(nums, 0, k-1)
        self.rev(nums, k, n-1)
        
    # reverse the array in place 
    def rev(self, nums, head, tail):
        # length of array
        n = tail - head + 1
        
        for _ in range(n//2):
            nums[head], nums[tail] = nums[tail], nums[head]
            head += 1
            tail -= 1
            
        return nums
    
    
# by shifting one element at a time
# time complexity - O(n)
# space complexity - O(1) -- rotate in-place
# did this code run on leetcode? - yes
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = maxrotate = len(nums)
        
        # run until all the elements have reached their new location. 
        for i in range(n):
            prev = nums[i]
            loc = i+k
            loc %= n
            
            while True:    # swaps elements at the location 
                prev, nums[loc] = nums[loc], prev
                maxrotate -= 1
                if loc==i:
                    break
                loc += k
                loc %= n
                
            # if no more rotations are required, break from the loop.
            if not maxrotate:
                break
                
        return nums