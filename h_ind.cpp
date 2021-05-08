//TC: O(nlogn)
//SC: O(1)

class Solution {
public:
    int hIndex(vector<int>& citations) {
        
        sort(citations.begin(), citations.end());
        
        //max h-index we can get have is the number of papers (size of the input array)
        
        //can use binary search to check if the value at the hth index of an array is at least equal to (n-h). 
        
        //we continuously search for the point where the above condition is true and we return the rightmost (n-h)th index.
        //eg.
        //for [0, 1, 3, 5, 6]
//(n-h)indexes:[5, 4, 3, 2, 1] (assuming we start from index 1)
        
        
        int low = 0;
        int high = citations.size()-1;
        
        //the n that will be used to calculate trial h-index
        int n = citations.size();
        
        //loop is less than equal to, low and high might come to the same point, and in that case, mid comes to the same point. We still have to check at this mid.
        while(low<=high){
            
            int mid = low + (high-low)/2;
            int thi = n - mid;
            
            if(thi == citations[mid]){
                return thi;
            }
            else if(thi > citations[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
            
        }
        
        return n-low;
        
                
    }
};