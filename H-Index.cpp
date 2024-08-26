//sorting sol - nlogn
/*
class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.size() == 0) return 0;
        sort(citations.begin(), citations.end());
        int n = citations.size();
        int low = 0; int high = n-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int diff = n-mid;
            if(citations[mid] == diff) return diff;
            else if(citations[mid] > diff) high = mid-1;
            else low = mid+1;
        }
        return n-low;
    }
};
*/

//bucket sort
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