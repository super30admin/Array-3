class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if(nums == None or n ==0):
            return 0
        if k > n:
            k = k % n
        res = []
        for i in range(k):
            res.append(self.rotateByOne(nums))
        #return res
        pass
    
    def rotateByOne(self, A):
        last = A[-1]
        for i in reversed(range(len(A) - 1)):
            A[i + 1] = A[i]

        A[0] = last
        pass
