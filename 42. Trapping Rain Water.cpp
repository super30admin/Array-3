/*
Time: O(n)
Space: O(n)

For every cell, count how much water can be stored in there
What is this amount?
Find the highest block in left and right of it
The minimum of these 2, subtracted by the current cell's height, will be the height of water stored on this cell
*/

class Solution {
public:
    stack<int> st;
    int n;
    vector<int> next_greater, prev_greater;
    

    void calc(vector<int>& v){
        next_greater = vector(n,0);
        prev_greater = vector(n,0);

        prev_greater[0] = 0;
        next_greater[n-1] = n-1;
        
        for(int i=1;i<n-1;i++)  prev_greater[i] = v[i] > v[prev_greater[i-1]] ? i : prev_greater[i-1];
        for(int i=n-2;i>=0;i--)  next_greater[i] = v[i] > v[next_greater[i+1]] ? i : next_greater[i+1];
    }
    
    int trap(vector<int>& v) {
        
        n = v.size();
        calc(v);

        int ans = 0;
        
        for(int i=1;i<n-1;i++){
            int nxt = next_greater[i]; 
            int prev = prev_greater[i];


            //water stored on this block = min(highest in left, hightest in right) - current blocks height
            if(nxt>=0 && prev<n)  ans += min(v[nxt], v[prev]) - v[i];
        }

        return ans;
    }
};
