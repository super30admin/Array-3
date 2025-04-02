// Time Complexity: O(nlogn)
// Space Complexity: O(1)
// Did the code run successfully? Yes

// Approach:
// 1. Sort the citations in descending order.
// 2. Initialize a variable h to 0 to keep track of the h-index.
// 3. Iterate through the sorted citations and check if the current citation is greater than or equal to the index + 1.
// 4. If it is, update h to index + 1.
// 5. If it is not, break the loop as we have found the h-index.
// 6. Return the value of h.

class Solution {
    public:
        int hIndex(vector<int>& citations) {
            sort(citations.begin(), citations.end());
            reverse(citations.begin(), citations.end());
            int h= 0;
            
            for(int i = 0; i < citations.size(); i++){
                if(citations[i] >= i + 1){
                    h = i + 1;
                }else{
                    break;
                }
            }
            return h;
        }
    };