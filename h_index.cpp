//Time O(n)
//Space O(n)
//Leetcode : yes
//issue seen: none
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> count(n+1, 0);
        
        for(int i=0; i < n; i++){
            if(citations[i] > n){
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        int hindex=0;
        for(int i=count.size()-1; i >=0; i--){
            hindex = hindex + count[i];
            if(hindex >= i) return i;
        }
        return -1;
    }
};
