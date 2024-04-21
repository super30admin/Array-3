/*
Time: O(n)
Space: O(1)

If we cyclic-shift k elements,
    - the last k elements are in first k positions
    - the first (n-k) elements are in last (n-k) positions

Just reversing the entire array places them in the correct partion (step 1)
The last k elements are in first k pos, but in reverse order, so reverse them again (step 2)
Similarly, last (n-k) elements are in reverse order, so reverse them again (step 3)
*/

class Solution {
public:
    void rotate(vector<int>& v, int k) {
        int n = v.size();
        k %= n; //reverting n times = reverting 0 times


        //step 1
        reverse(v.begin(), v.end());
        //step 2
        reverse(v.begin(), v.begin()+k); //second parameter is exclusive
        //step 3
        reverse(v.begin()+k, v.end());
    }
};
