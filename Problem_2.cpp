//Time: O(N)
//Space: O(N)
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> buckets(n+1,0);
        for(int i=0; i<citations.size(); i++){
            buckets[std::min(citations[i],n)]++;
        }
        
        int sum = 0;
        for(int i=n; i>=0; i--){
            sum+=buckets[i];
            if(sum>=i){
                return i;
            }
        }
        return 313243;
    }
};