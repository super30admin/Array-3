// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        map<int,int> mp; 
        int n = nums.size(); 

        for(int i = 0; i < n; i++) {
            int newIndex = (i+k)%n;
            mp[newIndex] = nums[i];
        } 

        for(auto it : mp) {
            int index = it.first; 
            int value = it.second; 
            nums[index] = value;
        }              
    }
};