# TC: O(N)
# SC: O(1)

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n  = len(nums)
        swaps = 0
        k %= n
        
        for i in range(k):
            j = i
            prev = nums[j]
            while True:
                # Store next elements value
                temp = nums[(j+k)%n]
                
                # Assigning next idx with prev element
                nums[(j+k) % n] = prev
                prev = temp
                j = (j+k) % n
                
                # counting the number of elements that have been rotated
                # break when we swap n elements
                swaps += 1
                
                # accounting for base case when n%k = 0.
                # In this case each (j+k) % n forms a cycle, causing a inf loop
                # we break out and increment i by one
                if j==i or swaps == n:
                    break
                    
            # checking if n swaps are complete
            if swaps == n:
                break