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

2. Pivot around tallest wall (Two pass approach) (sub-optimal)
We first find the index of the tallest bar to divide the array.
Then we sweep from the left to the tallest bar, collecting water where the left wall is taller. Next, we sweep from the right to the tallest bar, collecting water where the right wall is taller.
Time: O(2N), Space: O(1)
https://youtu.be/D2ANRf7G_0I?t=999 to https://youtu.be/D2ANRf7G_0I?t=2029


3. Two pointers (Single pass) (optimal)
For this, we use two pointers from both ends and keep track of the tallest walls on each side. At each step, we process the side with the smaller wall since that determines water trapping. We add trapped water if current height is less than the known max wall on that side.
Time: O(N), Space: O(1)
https://youtu.be/D2ANRf7G_0I?t=2035 to https://youtu.be/D2ANRf7G_0I?t=2735 (JS)
https://www.youtube.com/watch?v=aslfns1i0yY (RK)


4. Two pointers (Single pass) (optimal)
Same as the two pointers approach of #3. Code here is a bit easier to follow.
Time: O(N), Space: O(1)
https://youtu.be/UHHp8USwx4M?t=1051
Good explanation: https://youtu.be/UHHp8USwx4M?t=1335


5. Monotonic decreasing stack (sub-optimal) (new approach, useful to know but not popular)
We maintain a monotonically increasing stack of bar indices by height.
When we find a taller bar, it means we've found a right boundary and can now trap water over shorter bars in between. We calculate trapped water using the distance between boundaries and the bounded height.
Time: O(2N), Space: O(N)
https://youtu.be/D2ANRf7G_0I?t=2737 to https://youtu.be/D2ANRf7G_0I?t=4306

'''
from typing import List

def trap_PrefixSuffix(height: List[int]) -> int:
    '''
        Solution 1
        Time: O(N), Space: O(N)
    '''
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

def trap_TallestWall(height: List[int]) -> int:
    '''
        Solution 2
        Time: O(2N), Space: O(1)
    '''
    N = len(height)

    # Step 1: Find height and position of the tallest wall
    mx_ht, mx_id = 0, -1
    for i in range(N):
        if height[i] > mx_ht:
            mx_ht = height[i]
            mx_id = i

    # Step 2: Trap rain water on the left of tallest wall
    lw, l = 0, 0
    left_water = 0
    while l < mx_id:
        if lw > height[l]:
            left_water += (lw - height[l])*1
        else:
            lw = height[l]
        l += 1


    # Step 3: Trap rain water on the right of tallest wall
    rw, r = 0, N-1
    right_water = 0
    while r > mx_id:
        if rw > height[r]:
            right_water += (rw - height[r])*1
        else:
            rw = height[r]
        r -= 1

    return left_water + right_water


def trap_TwoPointer1(height: List[int]) -> int:
    '''
        Solution 3
        Time: O(N), Space: O(1)
    '''
    N = len(height)
    lw, rw = 0, 0 # left and right walls
    l , r = 0, N-1 # left and right pointers
    result = 0
    while l <= r:
        if lw <= rw:
            # Right wall bigger -> guaranteed to block water on right
            # Check if the left wall can trap water
            if lw >= height[l]:
                # left wall bigger than current brick -> trap water
                result += lw - height[l]
            else:
                # left wall smaller than current brick -> cannot trap water
                # hence, move left wall to right
                lw = height[l]
            l += 1
        else:
            # Left wall bigger -> guaranteed to block water on left
            # Check if the right wall can trap water
            if rw >= height[r]:
                # right wall bigger than current brick -> trap water
                result += rw - height[r]
            else:
                # right wall smaller than current brick -> cannot trap water
                # hence, move right wall to left
                rw = height[r]
            r -= 1
    return result

def trap_TwoPointer2(height: List[int]) -> int:
    '''
        Solution 4
        Time: O(N), Space: O(1)
    '''
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

def trap_Stack(height: List[int]) -> int:
    '''
        Solution 5
        Time: O(2N), Space: O(N)
    '''
    N = len(height)
    stack = [-1] # stack of indices, index = -1 (invalid)
    peek = -1
    result = 0
    for i in range(N):
        while stack[peek] != -1 and height[i] > height[stack[peek]]:
            # resolve the center
            pop = stack.pop() # center

            rw = height[i] # right wall
            if stack[peek] == -1:
                break
            j = stack[peek] # left wall index
            lw = height[j] # left wall
            width = i - j - 1
            result += (min(lw, rw) - height[pop])*width
        stack.append(i)
    return result


def run_tests():
    tests = [([0,1,0,2,1,0,1,3,2,1,2,1], 6),
             ([4,2,0,3,2,5], 9),
             ([1,2,3,4], 0),]
    for test in tests:
        height, ans = test[0], test[1]
        print(f"\nheight = {height}")
        for method in ['Prefix-Suffix', 'TallestWall', 'Two-Pointer1', 'Two-Pointer2', 'Stack']:
            if method == "Prefix-Suffix":
                area = trap_PrefixSuffix(height)
            elif method == 'TallestWall':
                area = trap_TallestWall(height)
            elif method == "Two-Pointer1":
                area = trap_TwoPointer1(height)
            elif method == "Two-Pointer2":
                area = trap_TwoPointer2(height)
            elif method == "Stack":
                area = trap_Stack(height)
            print(f"Method {method}: Area of trapped water = {area}")
            passed = (ans == area)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()
