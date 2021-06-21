/*Intuition: We can use count sort to count the number of citations. Whenever we cross a particular number
that would be the result.
/////////////////////////////////
Time Complexity: O(N)
Space Complexity: O(N)
/////////////////////////////////
*/
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();

        int count[n+1];
        for ( int i = 0 ; i < n+1; i++ ) count[i] =0;

        for ( auto citation: citations){
            if ( citation >= n)
                count[n] +=1;
            else
                count[citation] +=1;
        }
        for ( auto el: count) cout<<el<<" ";
        int sum = 0;
        for ( int i = n; i >=0; i--){
            sum += count[i];
            if ( sum >= i) return i;
        }
        return 0;
    }
};