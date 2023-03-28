"""
Rasika Sasturkar
Time Complexity: Brute force - O(nlogn), Optimal - O(n)
Space Complexity: Brute force - O(1), Optimal - O(n)
"""


def hIndex(citations) -> int:
    # null case
    if citations is None:
        return 0
    n = len(citations)

    # Brute force
    # citations = sorted(citations)
    #
    # # linear search
    # for i in range(n):
    #     diff = n - i
    #     if diff <= citations[i]:  # h-index
    #         return diff

    # using count sort
    buckets = [0 for _ in range(n + 1)]

    for i in range(n):
        if citations[i] >= n:
            buckets[n] += 1
        else:
            buckets[citations[i]] += 1
    sum = 0

    # iterate in reversed order
    for i in range(n, -1, -1):
        sum += buckets[i]
        if sum >= i:
            return i
    return 0


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(hIndex(citations=[3, 0, 6, 1, 5]))  # returns 3
    print(hIndex(citations=[1, 3, 1]))  # returns 1


if __name__ == "__main__":
    main()
