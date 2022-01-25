//Time complexity : O(n)
//Space complexity : O(n)

//Approach :
            // Create another array with index mapping to number of citations
            // Perform a reverse traversal with total count
            // If any of the index has count greater or equal to itself, then return that index

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.size() ==  0)
            return 0;
        
        vector<int> c(citations.size() + 1, 0);
        
        for(int i = 0 ; i < citations.size(); i++)
        {
            if(citations[i] >= citations.size())
            {
                c[citations.size()]++;
            }
            else
            {
                c[citations[i]]++;
            }
        }
           
        int result = 0;
           
        for(int i = c.size() - 1; i >= 0; i--)
        {
            result += c[i];
            if(result >= i)
            {
                return i;
            }
        }
           
        return 0;
    }
};