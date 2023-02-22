274. H-Index

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return compute the researcher's h-index.

According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.

If there are several possible values for h, the maximum one is taken as the h-index.


TC O(n) x O(nlogn) sort function
SC O(1)




class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int result = 0;
        sort(citations.begin(), citations.end());

        for (int i=0; i < n; i++) {
            int diff = n-i;

            if (diff <= citations[i]) {
                return diff;
            }
        }
        return 0;
    }
};
