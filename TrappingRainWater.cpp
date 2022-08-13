// Approach - 2 pass algorithm
// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int trap(vector<int>& height) {
        int answer = 0;
        int n = height.size();
        
        int slow = 0;
        int fast = 1;
        int currArea = 0;
        while(fast < n){
            if(height[slow] > height[fast])
                currArea += height[slow] - height[fast];

            else{
                answer += currArea;
                currArea = 0;
                slow = fast;
            }
            fast++;
        }
        currArea = 0;
        int peak = slow;
        slow = n-1;
        fast = slow -1;
        while(fast >= peak){
            if(height[slow] > height[fast])
                currArea += height[slow] - height[fast];
            
            else{
                answer += currArea;
                currArea = 0;
                slow = fast;
            }
            fast--;
        }
        return answer;
    }
};

// Approach - Finding peak and then traversing through the vector.
// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
class Solution {
public:
    int trap(vector<int>& height) {
        int answer = 0;
        int n = height.size();
        
        int slow = 0;
        int fast = 1;
        int currArea = 0;
        int peak = 0;
        
        for(int i = 0; i < n; i++){
            if(height[i] > height[peak])
                peak = i;
        }
        
        while(fast <= peak){
            if(height[slow] > height[fast])
                currArea += height[slow] - height[fast];

            else{
                answer += currArea;
                currArea = 0;
                slow = fast;
            }
            fast++;
        }
        
        currArea = 0;
        slow = n-1;
        fast = slow -1;
        while(fast >= peak){
            if(height[slow] > height[fast])
                currArea += height[slow] - height[fast];
            
            else{
                answer += currArea;
                currArea = 0;
                slow = fast;
            }
            fast--;
        }
        return answer;
    }
};

// Approach - 1 pass algorithm
// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int lw = 0;
        int rw = 0;
        int left = 0;
        int right = n-1;
        int answer = 0;
        
        while(left <= right){
            if(lw < rw){
                if(height[left] < lw)
                answer += lw - height[left];
            else
                lw = height[left];
                left++;
            }
            
            else{
            if(height[right] < rw)
                answer += rw - height[right];
            else
                rw = height[right];
                right--;
            }
        }
        return answer;
    }
};