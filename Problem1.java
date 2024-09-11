class Solution {
    public int trap(int[] height) {
        int max = Integer.MIN_VALUE;
        int capacity = 0;
        int index = -1;
        for(int i =0;i<height.length;i++){
            if(height[i]>max) {
                max = height[i];
                index = i;
            }

        }
        System.out.println(max + " and the index is " + index);

        int left = Integer.MIN_VALUE;
        //left
        for(int j = 0; j<index;j++){
            System.out.println( " The element is   " + height[j]);
            if(left < height[j]){
                left = height[j];
                System.out.println( " The change in left is   " + left);
            }
            
            else{
                capacity = capacity + (left - height[j]);
                System.out.println( " The variation in cap is   " + capacity);
            }
            


        }
        System.out.println( " The left after left is  " + left);
        //right
        int right = 0;
        for(int k = height.length-1;k>=index;k--){
            

            if(height[k]>right){
                right = height[k];
            }
            else{
                capacity = capacity + (right-height[k]);
            }
        }

        return capacity;
        
        
    }
}