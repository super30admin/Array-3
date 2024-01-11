//TC:O(n)
//SC: O(1)

class Solution {
public:
    int hIndex(vector<int>& citations) {
       int n = citations.size();
       int low = 0, high = n-1;

    while(low <= high)
    {
       int mid = low + high-low/2;
           int diff = n - mid;

           if(citations[mid] == diff)
           {
               return diff;
           }
           else if(citations[mid] < diff)
           {
               low = mid + 1;
           }
           else
           {
               high = mid - 1;
           }
       } 
       return (n - low);
    }
};