/*
TC = O(n)
SC = O(1)
where n is the size of the vector nums.
*/
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if(k>n)
            k=k%n;
        //reverse the whole vector
        reverse(nums.begin(),nums.end());
      
        //reverse the vector element from the start till start+k.
        reverse(nums.begin(),nums.begin()+k);
      
        //reverse the remaining vector.
        reverse(nums.begin()+k,nums.end());
    }
};
