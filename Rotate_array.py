# TC: O(N)
# SC: O(1)

class Solution:
    def reverse(self,nums,i,j):
        while i<j:
            temp=nums[j]
            nums[j]=nums[i]
            nums[i]=temp

            i+=1
            j-=1

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # nums=nums[::-1]
        # nums[:k]=nums[k-1::-1]
        # nums[k:]=nums[k:][::-1]

        k=k%len(nums)
        self.reverse(nums,0,len(nums)-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,len(nums)-1)
        print(nums)

        return nums