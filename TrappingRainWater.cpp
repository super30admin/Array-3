class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size()==0)
            return 0;
        int n=height.size();
        vector<int> left(n,0),right(n,0);
        
        left[0]=height[0];
        //cout<<left[0]<<" ";
        for (int i=1;i<height.size();i++) {
            left[i]=max(left[i-1],height[i]);
           // cout<<left[i]<<" ";
        }
        
        //cout<<endl;
        right[n-1]=height[n-1];
        //cout<<right[n-1]<<" ";
        for (int i=n-2;i>=0;i--) {
            right[i]=max(right[i+1],height[i]);
            //cout<<right[i]<<" ";
        }
        
        int sum=0;
        for (int i=0;i<n;i++) {
            sum+= min(left[i],right[i])-height[i];    
        }
        return sum;
    }
};