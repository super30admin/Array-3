/* 
    Time Complexity                              :  O(N Log N) using the normal sort technique
                                                    O(N) using counting sort
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/h-index/submissions/

class Solution {
public:
    int hIndex(vector<int>& citations) {
        // return hI(citations);
        return countingSort(citations);
        
    }
    
    
    // using sort O(N logN) time complexity
    int sortTechnique(vector<int>& cit) {
        int n = cit.size();
        sort(begin(cit), end(cit));
        
        for(int i=n;i>=1; i--) {
            int idx = n - i;
            if(cit[idx] >= i and (idx == 0 or cit[idx-1] <= i)) {
                return i;
            }
        }
        return 0;
    }
    
    int countingSort(vector<int>& cit) {
        int n = cit.size();
        vector<int> counts(n+1,0);
        for(auto c : cit) {
            // for the h index, the number of citations are linked to the number of papers
            // the index represents number of the papers and the value represents citations.
            // in this step we are changing the index from papers to citations in counts paper
            // the counts array stores the number of papers that have citations >= i where i is the index i.e. citations
            int idx = min(c,n);
            counts[idx]++;
        }
        
        int c = 0;
        // i is denoting the citations and counts[i] is the number of papers that have the citations
        for(int i=n;i>=0;i--) {
            c += counts[i];
            if(c >= i) 
                return i;
        }
        
        
        return 0;
        
    }
};