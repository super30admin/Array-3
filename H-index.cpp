// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build new array of size n + 1 using i/p array, index of array represents citations and its value represents no of papers that received.
 * If citation value in i/p array is greater than new results array then store that value at the last index of array.
 *
 * Iterate over results array and maintain running sum. 
 * If sum is greater than or equal to i then it means more than i papers have i or more than i citations.
 * Return i.  
 */

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if (citations.size() == 0)
        {
            return 0;
        }
        int n = citations.size();
        vector<int> results(n + 1, 0);
        
        for (int i = 0; i < n; i++)
        {
            if (citations[i] >= n)
            {
                results[n]++;
            }
            else
            {
                results[citations[i]]++;
            }
        }
        
        int sum = 0;
        
        for (int i = n; n >= 0; i--)
        {
            sum += results[i];
            
            if (sum >= i)
            {
                return i;
            }
        }
        
        return 0;
    }
};