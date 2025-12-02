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

Solution:
Formally, if f is the function that corresponds to the number of citations for each publication, we compute the h-index as follows: First we order the values of f from the largest to the lowest value. Then, we look for the last position in which f is greater than or equal to the position (we call h this position). For example, if we have a researcher with 5 publications A, B, C, D, and E with 10, 8, 5, 4, and 3 citations, respectively, the h-index is equal to 4 because the 4th publication has 4 citations and the 5th has only 3. However, if the same publications have 25, 8, 5, 3, and 3 citations, then the index is 3 (i.e. the 3rd position) because the fourth paper has only 3 citations.

    f(A)=10, f(B)=8, f(C)=5, f(D)=4, f(E)=3 → h-index=4
    f(A)=25, f(B)=8, f(C)=5, f(D)=3, f(E)=3 → h-index=3

Thus, if we have the function f ordered in decreasing order from the largest value to the lowest one, we can compute the h-index as follows:
Formula 1:    h-index (f) = max {i+1 ∈ N : f (i) ≥ i+1}, i = 0-indexed

Example 1:
f =   [6, 5, 3, 1, 0]
i =   [0, 1, 2, 3, 4]
i+1 = [1, 2, 3, 4, 5]
h-index (f) = max {1,2,3} = 3

Example 2:
f =   [10, 8, 5, 4, 3]
i =   [0,  1, 2, 3, 4]
i+1 = [1,  2, 3, 4, 5]
h-index (f) = max {1,2,3,4} = 4


If we have the function f ordered in increasing order from the smallest value to the largest one, we can compute the h-index as follows:
Formula 2:    h-index (f) = max {N-i, i ∈ N : f (i) ≥ N-i}
                          = N - min {i, i ∈ N : f (i) ≥ N-i}

Example 1:
f =   [0, 1, 3, 5, 6]
i =   [0, 1, 2, 3, 4]
N-i = [5, 4, 3, 2, 1]
h-index (f) = max {3,2,1} = 3

Thus,
f =   [0,  1,     3,     5,    6]
      --f(i)<N-i- | --f(i)>=N-i--
                h-index

Example 2:
f =   [3, 4, 5, 8, 10]
i =   [0, 1, 2, 3, 4]
N-i = [5, 4, 3, 2, 1]
h-index (f) = max {4,3,2,1} = 4

1. Brute Force
N papers can have a min h-index = 0 and max h-index = N. Hence, possible values of hindex = [0, N] for N papers. Hence, for each posible value of hindex (call it i), count the number of papers whose citations >= i. If this condition is saistsfied, i becomes a potential hindex value. Since we would like to get the  max possible value of i, we continue incrementing i and count the no. of papers whose citations >= i.
https://youtu.be/M8AX7QvCtsg?t=3075
Time: O(N^2), Space: O(1)


2. Sort and linear search
Sort the array in increasing order. Traverse the sorted array from left to right. If the ith element of array is f[i], then we are looking for the first instance when f[i] >= N-i. When that happens, return N-i.
https://youtu.be/M8AX7QvCtsg?t=3237
Time: O(N log N), Space: O(1)

3. Count Sort
For N papers, possible values of hindex = [0,1,2,...,N] (N+1 values)
Create a bucket (array) of size N+1. The indices of the bucket are the possible values of hindex.

Now for each citation count (of N papers), use the citation count as the index of the bucket and add 1 to the value of the array at that index. That is,
if citation < N, then bucket[citation] += 1
if citation >= N, then bucket[N] += 1

After filling the bucket, start from the end of the bucket (j = N). set sum = bucket[j]. If sum >= j, then hindex = j. This is because 'sum' is the no. of papers having at least j citations. By defn, hindex = h means there are h papers having at least h citations. Hence, coming back to our bucket array,  there are 'sum' papers having at least j citations. Thus, if sum >= j, then hindex = j.

If sum < j, decrease j by 1 and increase sum to sum = sum + bucket[j]. The first j where sum >= j is the hindex.

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
    for c in citations: # O(N)
        if c >=N:
            buckets[N] += 1
        else:
            buckets[c] += 1

    # buckets[c] = n means there are n papers
    # which have received c citations

    num_papers = 0
    h = 0
    for ncite in range(N,-1,-1):
        num_papers += buckets[ncite]
        if num_papers >= ncite:
           h = ncite
           break
    return h

def run_hIndex():
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
            success = (ans == hIndex)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_hIndex()