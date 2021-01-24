//Time - O(n)
//Space - O(n)
class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        int N = citations.size();
        if(N == 0) return 0;
        vector<int> buckets (N+1);
        
        
        for(int i=0;i<N;i++){
            if(citations[i]>=N) buckets[N]++;
            else buckets[citations[i]]++;
        }
        int sum = 0;
        
        for(int i=N;i>=0;i--){
            sum+=buckets[i];
            if(sum>=i) return i;
        }
        
        return 0;
        
    }
};