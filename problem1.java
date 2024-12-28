public class problem1 {
// Approach 1
// Time Complexity: 0(n)
// Space Complexity:0(1)
    public int trap(int[] height) {
        int n = height.length;
        int maxIdx=-1;
        int maxHeight=0;

        for (int i = 0; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIdx = i;
            }

        }
        int result=0;
        int l=0,lw=0;
        while(l<maxIdx)
        {
            if (lw>height[l])
            {
                result+=lw-height[l];
            }
            else {
                lw=height[l];
            }
            l++;
        }
        int r=n-1, rw=0;
        while(r>maxIdx)
        {
            if (rw>height[r])
            {
                result+=rw-height[r];
            }
            else {
                rw=height[r];
            }
            r--;
        }


        return result;


    }
// Approach2
    public int trap1(int[] height) {
        int n = height.length;
        int r=n-1, rw=0;
        int result=0;
        int l=0,lw=0;
        while(l<=r)
        {
            if(lw<rw)
            {
                if (lw>height[l])
                {
                    result+=lw-height[l];
                }
                else {
                    lw=height[l];
                }
                l++;
            }
            else {
                if (rw>height[r])
                {
                    result+=rw-height[r];
                }
                else {
                    rw=height[r];
                }
                r--;
            }

        }



        return result;


    }
}
