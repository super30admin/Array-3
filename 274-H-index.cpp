/*
TC = O(n)
SC = O(n)
where n is the size of the citations array.
*/
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector <int> arr(n+1,0);
        int i;
        for(i=0;i<n;i++)
        {
            if(citations[i]>=n)
                arr[n]++;
            else
                arr[citations[i]]++;
        }
        int sum=0;
        for(i=n;i>=0;i--)
        {
            sum=sum+arr[i];
            if(sum>=i)
                return i;
        }
        return 0;
    }
};
