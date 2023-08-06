class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end());
        int max_H = -1;
        int x = citations.size(); 

        for(int i = 0; i < citations.size(); i++) {
            if(citations[i] >= x) return x;
            x--;
        }

        return 0;              
    }
};