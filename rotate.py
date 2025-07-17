# TimeComplexity:O(n)
# SpaceComplexity:Consatnt
# Approach:
# rotating  k times is same as reverse array and reverse first k ele and then remaing elements




class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def rev(l,h):
            while(l<h):
                nums[l],nums[h]=nums[h],nums[l]
                l+=1
                h-=1

        #reverse current array
        n=len(nums)
        if n==1:
            a=1
        else:
            l,h=0, n-1
            k=k%n
            rev(l,h)
            # print(nums,1)
            l=0
            h=k-1
            rev(l,h)
            l=k
            h=n-1
            rev(l,h)
            # print(nums,3)
