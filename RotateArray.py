"""
Time Complexity - O(K)
space complexity - O(1)

"""
def rotate(self, nums, k):

    while k > 0:
        q = nums.pop()
        k -= 1
        nums.insert(0,q)