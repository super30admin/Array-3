// Time Complexity: O(min(n*k, n*(n-k))) n = size of nums
// Space Complexity: O(1)
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size() == 1) return;
        if(k > nums.size())
            k -= nums.size();
        else if(k == nums.size())
            return;
        
        if(k <= (nums.size()-1)/2) {
            while(k--) { // O(k)
                int end = nums.back();
                nums.pop_back();
                nums.insert(nums.begin(), end); // O(n)
            }
        }
        else {
            int temp = nums.size()-k;
                while(temp--) { // O(n-k)
                    int front = nums.front();
                    nums.erase(nums.begin()); // O(n)
                    nums.push_back(front);
                }
        }
    }
};

// Time Complexity: O(n) 
// Space Complexity: O(n)
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        vector<int> res;
        if(k > nums.size())
            k -= nums.size();
        else if(k == nums.size())
            return;
        
        for(int i = nums.size()-k; i < nums.size(); i++) {
            res.push_back(nums[i]);
        }
        
        for(int i = 0; i < nums.size()-k; i++) {
            res.push_back(nums[i]);
        }
        
        nums = res;
        res.clear();
    }
};

// Time Complexity: O(n) n = size of nums vector
// Space Complexity: O(1)
class Solution {
public:
    void reverse(vector<int>& nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    void rotate(vector<int>& nums, int k) {
        if(k > nums.size())
            k %= nums.size();
        if(k == nums.size() || k == 0)
            return;
        
        reverse(nums, nums.size()-k, nums.size()-1); // O(k)
        reverse(nums, 0, nums.size()-k-1); // O(n-k)
        reverse(nums, 0, nums.size()-1); // O(n)
    }
};
