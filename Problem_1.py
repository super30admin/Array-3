'''
42 Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

Solution:
1. Prefix and Suffix array (sub-optimal)
Compute a running max of height from start of the array (index = 0) to current index i, where 0<=i<=N-1. Save the max values in L. Thus, L[i] = max value of height from index 0 to index i. This is the prefix array.

Compute a running max of height from end of the array (index = N-1) to current index i, where 0<=i<=N-1. Save the max values in R. Thus, R[i] = max value of height from index N-1 to index i. This is the suffix array.

Now compute the total water in bin i using min(L(i), R(i)) - height[i]. Calculate this for all bins and add up.
Time: O(N), Space: O(N)

2. Two pointers (optimal)
This technique reduces the O(N) space used in the prefix-suffix array approach to O(1) space. For this, we use two pointers from both ends and keep track of the tallest walls on each side. At each step, we process the side with the smaller wall since that determines water trapping. We add trapped water if current height is less than the known max wall on that side.
https://www.youtube.com/watch?v=aslfns1i0yY
Time: O(N), Space: O(1)


3. Two pointers (optimal)
Same as the Two pointers approach in #2. Code here is a bit easier to follow.
https://youtu.be/UHHp8USwx4M?t=1051
Good explanation: https://youtu.be/UHHp8USwx4M?t=1335
Time: O(N), Space: O(1)

'''
from typing import List
def trap_PrefixSuffix(height: List[int]) -> int:
    N = len(height)
    L = [0]*(N) # L[i] = max value of height from index 0 to index i
    R = [0]*(N) # R[i] = max value of height from index N-1 to index i

    L[0] = height[0]
    R[N-1] = height[N-1]
    for i in range(1, N): # O(N)
        L[i] = max(L[i-1], height[i])
        R[N-i-1] = max(R[N-i], height[N-i-1])

    area = 0
    for i in range(N): # O(N)
        this = min(L[i], R[i]) - height[i]
        area += this
    return area

def trap_TwoPointer2(height: List[int]) -> int:
    N = len(height)
    lw, l = 0, 0
    rw, r = 0, N-1
    result = 0
    while l <= r:
        if lw <= rw:
            if lw >= height[l]:
                result += lw - height[l]
            else:
                lw = height[l]
            l += 1
        else:
            if rw >= height[r]:
                result += rw - height[r]
            else:
                rw = height[r]
            r -= 1
    return result

def trap_TwoPointer3(height: List[int]) -> int:
    N = len(height)
    # init max height on the left and right to 0
    # since we can assume that the max ht to the left of height[0]
    # is 0. Likewise, max ht to the right of height[N-1] is 0
    lmax, rmax = 0, 0
    # two pointers
    l, r = 0, N-1
    # area of trapped water
    result = 0
    while l <= r:
        lmax = max(lmax, height[l])
        rmax = max(rmax, height[r])
        if lmax <= rmax:
            result += max(lmax - height[l], 0)
            l += 1
        else:
            result += max(rmax - height[r], 0)
            r -= 1
    return result

def run_trap():
    tests = [([0,1,0,2,1,0,1,3,2,1,2,1], 6),
             ([4,2,0,3,2,5], 9),
             ([1,2,3,4], 0),]
    for test in tests:
        height, ans = test[0], test[1]
        print(f"\nheight = {height}")
        for method in ['Prefix-Suffix', 'Two-Pointer2', 'Two-Pointer3']:
            if method == "Prefix-Suffix":
                area = trap_PrefixSuffix(height)
            elif method == "Two-Pointer2":
                area = trap_TwoPointer2(height)
            elif method == "Two-Pointer3":
                area = trap_TwoPointer3(height)
            print(f"Method {method}: Area of trapped water = {area}")
            success = (ans == area)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_trap()
