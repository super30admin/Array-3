//time: O(n)
//space: O(1)

class Solution {
public:
    int trap(vector<int>& height) {
        int max=0;
        int idx = -1;
        int n = height.size();
        int vol=0;

        for(int i=0;i<n;i++){
            if(height[i]>max){
                max = height[i];
                idx = i;
            }

        }

        int lw=0;//height;
        int l=0;

        while(l<idx){
            if(lw<=height[l]){
                lw = height[l];
                
            }
            else{
                vol+=(lw-height[l]);

            }
            l++;


        }

        int rw = 0;
        int r = n-1;

        while(r>idx){
            if(rw<height[r]){
                rw = height[r];
                
                
            }
            else{
                vol+=(rw-height[r]);

            }
            r--;

        }

        return vol;



        

        
    }
};