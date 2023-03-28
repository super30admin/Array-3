"""
Rasika Sasturkar
Time Complexity: O(n), where n is total no. of heights in the array
Space Complexity: O(1)
"""


def trap(height) -> int:
    """
    Solved using 4 pointers where left & left_wall are processing left side
    and right & right_wall are required to process right side. Here, we make
    sure that there is a wall at the left/right side before we trap the water.
    """
    # null case
    if height is None:
        return 0

    result = 0
    left, lw = 0, 0
    right, rw = len(height) - 1, 0

    while left <= right:
        if lw <= rw:  # process left side
            if height[left] >= lw:
                lw = height[left]
            else:  # trap the water
                result += (lw - height[left])
            left += 1
        else:  # process right side
            if height[right] >= rw:
                rw = height[right]
            else:  # trap the water
                result += (rw - height[right])
            right -= 1

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(trap(height=[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))  # returns 6
    print(trap(height=[4, 2, 0, 3, 2, 5]))  # returns 9


if __name__ == "__main__":
    main()
