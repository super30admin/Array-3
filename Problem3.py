#I handle the rotation in two different ways depending on the value of k relative to the length of the array. If k is zero, no rotation is needed, so I simply return. If the length of nums is greater than k, I perform the rotation in-place by slicing the array into two parts: the last k elements and the rest of the elements, and then concatenate these parts in the reversed order. If k is greater than or equal to the length of nums, I perform the rotation k times by repeatedly moving the last element to the front of the array. This solution efficiently handles both small and large values of k, with the time complexity being O(n) for the slicing approach and O(nk) for the repeated rotation approach when k is greater than the length of the array. The space complexity is O(n) in both cases due to the need to create new lists for the slices or rotations.

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k == 0:
            return
        elif len(nums) > k:
            nums[:] = nums[-k:] + nums[:(len(nums) - k)]
        else:
            for i in range(k):
                rotation = nums[:-1]
                rotation.insert(0, nums[-1])
                nums[:] = rotation