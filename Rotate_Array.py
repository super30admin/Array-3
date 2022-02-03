class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
        Rotate Array
        Time complexity : O(N)
        Space Complexity : O(1)
        """
        self.visited = set()
        for i in range(len(nums)):
            index = i
            temp = nums[i]
            while index not in self.visited:
                
                new_index = (index+k)%len(nums)
                # print(index,new_index)
                
                temp1 = nums[new_index]
                nums[new_index] = temp
                self.visited.add(index)
                index = new_index
                temp = temp1
                
        
                
        
        
        
            
            
        