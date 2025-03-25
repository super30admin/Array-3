// https://leetcode.com/problems/trapping-rain-water/description/
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public:
        int trap(vector<int>& height) {
            int n = height.size();
            int left=0; int right = n-1;
            int left_max=0; int right_max=0;
            int ans = 0;
            while(left <= right){
                if(height[left] <= height[right]){
                    if(height[left] >= left_max){
                        left_max = height[left];
                    }
                    else{
                        ans += left_max - height[left];
                    }
                    left++;
                }
                else{
                    if(height[right] >= right_max){
                        right_max = height[right];
                    }
                    else{
                        ans += right_max - height[right];
                    }
                    right--;
                }
                
    
            }
            return ans;
        }
    };


// Monotonic decrese stack
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public:
        int trap(vector<int>& height) {
            int n = height.size();
            int ans = 0;
            stack<int> st;
            st.push(-1);
            for(int i=0; i<n; i++){
                while(st.top() != -1 && height[st.top()] < height[i]){
                    int popped = st.top(); st.pop();
                    if(st.top() == -1) break;
                    int rw = height[i]; int lw = height[st.top()];
                    int w = i-st.top()-1;
                    ans += w * (min(lw, rw) - height[popped]);
                }
                st.push(i);
            }        
            return ans;
        }
    };