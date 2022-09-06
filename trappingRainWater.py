#Time Complexity :o(N)
#Space Complexity: O(N)
def trap(self, height: List[int]) -> int:
    if not height:
        return 0

    leftBoundary = [0] * len(height)
    rightBoundary = [0] * len(height)

    leftBoundary[0] = height[0]
    rightBoundary[-1] = height[-1]

    for idx in range(1, len(height)):
        leftBoundary[idx] = max(height[idx], leftBoundary[idx - 1])

    for idx in range(len(height) - 2, -1, -1):
        rightBoundary[idx] = max(height[idx], rightBoundary[idx + 1])

    result = 0

    for i in range(1, len(height)):
        result += min(leftBoundary[i], rightBoundary[i]) - height[i]

    # print(leftBoundary, rightBoundary)
    return result

