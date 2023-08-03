public class Problem42 {
    //TC=O(n)
//SC=O(1)
    public int trap1(int[] height) {
        int n=height.length;
        int max=0;
        int maxHeightIdx=-1;
        int maxArea=0;

        for(int i=0;i<n;i++){
            if(height[i]>max){
                max=height[i];
                maxHeightIdx=i;
            }
        }
        int lw=0;
        for(int j=0;j<maxHeightIdx;j++){
            if(height[j]<lw){
                maxArea+=lw-height[j];
            }
            else{
                lw=height[j];
            }
        }
        int rw=0;
        for(int j=n-1;j>maxHeightIdx;j--){
            if(height[j]<rw){
                maxArea+=rw-height[j];
            }
            else{
                rw=height[j];
            }
        }
        return maxArea;
    }
    public int trap(int[] height) {
        int rightPointer=height.length-1;
        int lw=0;
        int rw=0;
        int leftPointer=0;
        int maxArea=0;
        while(leftPointer<=rightPointer){
            if(lw<=rw){
                if(height[leftPointer]<lw){
                    maxArea+=lw-height[leftPointer];
                }
                else{
                    lw=height[leftPointer];
                }
                leftPointer++;
            }
            else{
                if(height[rightPointer]<rw){
                    maxArea+=rw-height[rightPointer];
                }
                else{
                    rw=height[rightPointer];
                }
                rightPointer--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Problem42 problem=new Problem42();
        System.out.println(problem.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(problem.trap1(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
