/*Time Complexity: O(N)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: Using bucket sort - finding the freq of the citataions, storing it in bucket
vector and checking if its greater than h-index.

Prob: 274. H-Index
*/

#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int hIndex(vector<int> &citations)
    {
        int n = citations.size();
        vector<int> bucket(n + 1);
        for (auto el : citations)
        {
            if (el >= n)
            {
                bucket[n]++;
            }
            else
            {
                bucket[el]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--)
        {
            sum += bucket[i];
            if (sum >= i)
            {
                return i;
            }
        }
        return 1e9;
    }
};