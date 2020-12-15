#As taught in class, using series of reverseing elements to solve this problem
#Time COmplexity: O(n)
#Space Complexity: O(1)
def rotate(self, nums: List[int], k: int) -> None:
    if nums is None or len(nums)==0:
        return
    n = len(nums)
    if k > n:
        k = k % n
    self.rev(nums,0,n-1)
    self.rev(nums,0,k-1)
    self.rev(nums,k,n-1)
    
def rev(self,nums,l,r):
    while(l<r):
        temp = nums[l]
        nums[l] = nums[r]
        nums[r] = temp
        l = l + 1
        r = r - 1