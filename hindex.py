'''
274 H-Index
https://leetcode.com/problems/h-index/description/

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

Example 1:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

Example 2:
Input: citations = [1,3,1]
Output: 1

Constraints:
n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000

Formally, if f is an array that corresponds to the number of citations for each publication, we compute the h-index as follows: First we order the values of f from the largest to the lowest value. Then, we look for the last position in which f is greater than or equal to the position (we call h this position).

For example, if we have a researcher with 5 publications A, B, C, D, and E with 10, 8, 5, 4, and 3 citations, respectively, the h-index is equal to 4 because there are 4 publications (A, B, C, D)  with citations 10, 8, 5, 4 (>= 4 citations).

However, if the same researcher has 25, 8, 5, 3, 3 citations, then the h-index is 3 (i.e. the 3rd position) because there are 3 papers (C, D, E) with citations 5, 3, 3 respectively (>= 3 citations)


Formulae for h-index:
1. If f is arranged in decreasing order:
Formula 1:    h-index (f) = max {i+1 ∈ N : f (i) ≥ i+1}
                          = 1 + max {i ∈ N : f (i) ≥ i+1}

2.  If f is arranged in inreasing order:
Formula 2:    h-index (f) = max {N-i, i ∈ N : f (i) ≥ N-i}
                          = N + max {-i, i ∈ N : f (i) ≥ N-i}
                          = N - min {i, i ∈ N : f (i) ≥ N-i}

Example 1:
f =   [6, 5, 3, 1, 0] (decreasing order)
i =   [0, 1, 2, 3, 4]
i+1 = [1, 2, 3, 4, 5]
i   f(i)    i+1     f(i) >= i+1?
0   6       1           T
1   5       2           T
2   3       3           T
3   1       4           F
4   0       5           F
h-index (f) = 1 + max {0,1,2} = 1 + 2 = 3

Example 2:
f =   [10, 8, 5, 4, 3] (decreasing order)
i =   [0,  1, 2, 3, 4]
i+1 = [1,  2, 3, 4, 5]
h-index (f) = 1 + max {0,1,2,3} = 4


Example 3:
f =   [0, 1, 3, 5, 6] (increasing order)
i =   [0, 1, 2, 3, 4]
N-i = [5, 4, 3, 2, 1]
Q to ask is: Find the first i such that f(i) >= N-i
i   f(i)    N-i     f(i) >= N-i?
0   0       5           F
1   1       4           F
2   3       3           T
3   5       2           T
4   6       1           T
h-index (f) = N - min {2,3,4} = 5 - 2 = 3
Thus,
f =   [0,  1,     3,     5,    6]
      --f(i)<N-i- | --f(i)>=N-i--
                h-index

Example 4:
f =   [3, 4, 5, 8, 10] (increasing order)
i =   [0, 1, 2, 3, 4]
N-i = [5, 4, 3, 2, 1]
h-index (f) = N - min {1,2,3,4} = 5 - 1 = 4

1. Brute Force
N papers can have a min h-index = 0 and max h-index = N. Hence, possible values of hindex = [0, N] for N papers. Hence, for each posible value of hindex (call it i), count the number of papers whose citations >= i. If this condition is saistsfied, i becomes a potential hindex value. Since we would like to get the  max possible value of i, we continue incrementing i and count the no. of papers whose citations >= i.
https://youtu.be/M8AX7QvCtsg?t=3075
Time: O(N^2), Space: O(1)


2. Sort and linear search
Sort the array in increasing order. Traverse the sorted array from left to right. If the ith element of array is f[i], then we are looking for the first instance when f[i] >= N-i. When that happens, return N-i.
https://youtu.be/M8AX7QvCtsg?t=3237
Time: O(N log N), Space: O(1)

3. Count Sort
For N papers, possible values of hindex = [0,1,2,...,N]
Create a bucket (array) of size N+1. The indices of the bucket are the possible values of hindex.

Now for each citation count (citations[i], i=0,..,N-1), use the citation count as the index of the bucket and add 1 to the value of the array at that index. This means we are trying to maintain a freq count (count no. of papers) that have been cited citations[i] times.

Let citation = citations[i]
If citation < N, then bucket[citation] += 1
If citation >= N, then bucket[N] += 1

After filling the bucket, maintain a running sum (rsum) of the freq counts starting from the end of the last bucket (j = N).

As soon as rsum >= j, we declare hindex = j. This is because 'rsum' is the no. of papers having at least j citations. By defn, hindex = h means there are h papers having at least h citations. Hence, coming back to our bucket array,  there are 'rsum' papers having at least j citations. Thus, if rsum >= j, then hindex = j.

This is also known as count sort.

https://youtu.be/M8AX7QvCtsg?t=3727
https://youtu.be/mgG5KFTvfPw?t=274 (easy to understand)
Time: O(N), Space: O(N)

'''
def hIndex_1(citations):
    ''' Time: O(N^2), Space: O(1) '''
    if not citations:
        return 0
    N = len(citations)
    hindex = 0
    for i in range(N+1): # O(N)
        count = 0
        for num in citations: # O(N)
            if num >= i:
                count += 1
        if count >= i:
            hindex = max(hindex, i)
    return hindex

def hIndex_2(citations):
    '''Time: O(N log N), Space: O(1)'''
    if not citations:
        return 0
    N = len(citations)

    # sort by increasing order of citations
    # citations = sorted(citations)
    # for i in range(N):
    #     if citations[i] >= N-i:
    #         return N-i
    # return 0

    # sort by decreasing order of citations (more natural than increasing order)
    citations.sort(reverse=True)
    N = len(citations)
    h = 0
    for i in range(N):
        if citations[i] >= i+1:
            h += 1
    return h

def hIndex_3(citations):
    '''Time: O(N), Space: O(N)'''
    if not citations:
        return 0
    N = len(citations)
    buckets = [0]*(N+1)
    for c in citations:
        if c >= N:
            buckets[N] += 1
        else:
            buckets[c] += 1

    # buckets[c] = n means there are n papers
    # which have received c citations

    hindex = 0
    count = 0 # running sum
    for h in range(N, -1, -1):
        count += buckets[h]
        if count >= h:
            hindex = h
            break
    return hindex



def run_tests():
    tests = [([3,0,6,1,5], 3), ([1,3,1],1), ([0,0,0,0,0],0)]
    for test in tests:
        citations, ans = test[0], test[1]
        print(f"\ncitations = {citations}")
        for method in ['brute-force','sort-search', 'bucket-sort']:
            if method == 'brute-force':
                hIndex = hIndex_1(citations)
            elif method ==  'sort-search':
                hIndex = hIndex_2(citations)
            elif method == 'bucket-sort':
                hIndex = hIndex_3(citations)
            print(f"Method {method}: hIndex = {hIndex}")
            passed = (ans == hIndex)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()