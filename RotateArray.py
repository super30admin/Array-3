"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(1)
"""


def rotate(nums, k: int) -> None:
    """
    Do not return anything, modify nums in-place instead.
    First we reversed all the elements, then reversed first k elements
    and last step was to reverse elements from k to n-1.
    """
    # null case
    if nums is None:
        return

    n = len(nums)

    # if k is greater than length of list
    if k >= n:
        k = k % n

    def swap(nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]

    def reverse(nums, left, right):
        while left <= right:
            swap(nums, left, right)
            left += 1
            right -= 1

    reverse(nums, 0, n - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, n - 1)
    print(nums)


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    rotate(nums=[1, 2, 3, 4, 5, 6, 7], k=3)  # prints [5, 6, 7, 1, 2, 3, 4]
    rotate(nums=[-1, -100, 3, 99], k=2)  # prints [3, 99, -1, -100]


if __name__ == "__main__":
    main()
