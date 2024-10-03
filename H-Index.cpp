//time: O(n)
//space: O(n)
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> vec(n+1);
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                vec[n]++;
            }
            else vec[citations[i]]++;
        }
        int atleast = vec[n];
        for(int i = n; i >= 0; i--) {
            if(i != n) {
                atleast += vec[i];
            }
            if(atleast >= i) {
                return i;
            }
        }
        return 0;
    }
};