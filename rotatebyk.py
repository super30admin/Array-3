class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # l = [0 for i in range(len(nums))]
        # n=len(nums)
        # for i in range(len(nums)): 
        #     if i+k<n:
        #         l[i+k]=nums[i]
        #     else:
        #         x=(i+k)%n
        #         l[x]=nums[i]      
        # for i in range(len(l)):
        #     nums[i]=l[i]
        # return

        # since the first n-k elements and the last k elements can be grouped together,
        # reverse both of them individually and reverse entire array
        #[1,2,3,4,5,6,7] = [4,3,2,1,7,6,5] = [5,6,7,1,2,3,4]
        #TC-O(n), SC-O(1)
        n=len(nums)
        def reverse(nums,s,e):
            
            start=s
            end = e-1
            while start<=end:
                t=nums[start]
                nums[start]=nums[end]
                nums[end]=t
                start+=1
                end-=1
            print(nums)
            return nums
        if(k>n):
            k=k%n
        nums = reverse(nums,0,n-k)
        nums = reverse(nums,n-k,n)
        nums = reverse(nums,0,n)
